package com.template.contracts

import com.template.states.MsgState
import org.junit.Test
import kotlin.test.assertEquals

class StateTests {
    @Test
    fun hasFieldOfCorrectType() {
        // Does the field exist?
        MsgState::class.java.getDeclaredField("msg")
        // Is the field of the correct type?
        assertEquals(MsgState::class.java.getDeclaredField("msg").type, String()::class.java)
    }
}