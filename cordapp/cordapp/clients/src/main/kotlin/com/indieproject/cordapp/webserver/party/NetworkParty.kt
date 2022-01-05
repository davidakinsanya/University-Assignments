package com.indieproject.cordapp.webserver.party

import net.corda.core.identity.CordaX500Name
import net.corda.core.identity.Party
import java.security.KeyPairGenerator
import java.security.PublicKey

class NetworkParty {
  
  
  private val partyA = Party(name = CordaX500Name.parse("Eryk"), owningKey = this.getPublicKey())
  private val partyB = Party(name = CordaX500Name.parse("Laadi"), owningKey = this.getPublicKey())
  private val partyC = Party(name = CordaX500Name.parse("Kieran"), owningKey = this.getPublicKey())
  
  private fun getPublicKey(): PublicKey {
    val keyGen = KeyPairGenerator.getInstance("RSA", "SUN")
    val keyPair = keyGen.generateKeyPair()
    return keyPair.public
  }
  
  fun getPartyList(): List<Party> {
    return listOf<Party>(this.partyA, this.partyB, this.partyC)
  }
}