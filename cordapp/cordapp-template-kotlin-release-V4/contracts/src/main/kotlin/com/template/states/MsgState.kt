package com.template.states

import com.template.contracts.MsgContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party

// *********
// * State *
// *********
@BelongsToContract(MsgContract::class)
data class MsgState(val msg: String,
                    val sender: Party,
                    val receiver: Party,
                    override val participants: List<AbstractParty> = listOf(sender,receiver)
) : ContractState
