package com.indieproject.cordapp.webserver.utils

import net.corda.client.rpc.CordaRPCClient
import net.corda.client.rpc.CordaRPCConnection
import net.corda.core.utilities.NetworkHostAndPort



fun connectToNode(): CordaRPCConnection {
<<<<<<< HEAD
  val host: String = "159.223.165.12"
=======
  val host: String = "localhost"
>>>>>>> 2c6d15d8248a513220b05fb9bdda354e0809a6f0
  val rpcPort: Int = 10006
  val username: String = "user1"
  val password: String = "test"
  
  val rpcAddress = NetworkHostAndPort(host, rpcPort)
  val rpcClient = CordaRPCClient(rpcAddress)
  
  return rpcClient.start(username, password)
}
