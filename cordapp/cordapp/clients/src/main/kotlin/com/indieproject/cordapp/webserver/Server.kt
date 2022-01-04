package com.indieproject.cordapp.webserver

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.corda.client.jackson.JacksonSupport
import net.corda.client.rpc.CordaRPCClient
import net.corda.client.rpc.CordaRPCConnection
import net.corda.core.messaging.CordaRPCOps
import net.corda.core.utilities.NetworkHostAndPort
import org.slf4j.event.Level
import java.util.concurrent.TimeUnit

fun ContentNegotiation.Configuration.cordaJackson(proxy: CordaRPCOps) {
    val mapper: ObjectMapper = JacksonSupport.createDefaultMapper(proxy)
    mapper.apply {
        setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
            indentArraysWith(DefaultPrettyPrinter.FixedSpaceIndenter.instance)
            indentObjectsWith(DefaultIndenter("  ", "\n"))
        })
    }
    val converter = JacksonConverter(mapper)
    register(ContentType.Application.Json, converter)
}

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 10050) {
        mainModule(args)
    }.start().addShutdownHook()
}

fun Application.mainModule(args: Array<String>) {
    val connection: CordaRPCConnection = connectToNode(args)
    install(CallLogging) { level = Level.INFO }
    install(ContentNegotiation) { cordaJackson(connection.proxy) }
    routing { msgRouting() }
    addShutdownEvent(connection)
}

fun connectToNode(args: Array<String>): CordaRPCConnection {
    val host: String = args[0]
    val rpcPort: Int = args[1].toInt()
    val username: String = args[2]
    val password: String = args[3]
    
    val rpcAddress = NetworkHostAndPort(host, rpcPort)
    val rpcClient = CordaRPCClient(rpcAddress)
    
    return rpcClient.start(username, password)
}

fun NettyApplicationEngine.addShutdownHook() {
    Runtime.getRuntime().addShutdownHook(Thread {
        stop(1, 1, TimeUnit.SECONDS)
    })
    Thread.currentThread().join()
}

fun Application.addShutdownEvent(connection: CordaRPCConnection) {
    environment.monitor.subscribe(ApplicationStopped) {
        connection.notifyServerAndClose()
    }
}
