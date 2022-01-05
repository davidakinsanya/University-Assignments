package com.indieproject.cordapp.webserver

import net.corda.client.rpc.CordaRPCClient
import net.corda.client.rpc.CordaRPCConnection
import net.corda.core.utilities.NetworkHostAndPort

fun connectToNode(args: Array<String>): CordaRPCConnection {
  val host: String = args[0]
  val rpcPort: Int = args[1].toInt()
  val username: String = args[2]
  val password: String = args[3]
  
  val rpcAddress = NetworkHostAndPort(host, rpcPort)
  val rpcClient = CordaRPCClient(rpcAddress)
  
  return rpcClient.start(username, password)
}