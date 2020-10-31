package com.normAlgorifm.mikrise2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import replaceRange


class Test {

    @Test
    fun test() {
        val testedLine = "abcd"
        val oldValue = "ab"
        val newValue = "c"

        val startIndex = 0
        val expectedLine = "ccd"

        val newLine = testedLine.replaceRange(startIndex, oldValue, newValue)
        Assertions.assertEquals(expectedLine, newLine)
    }

}