package com.normAlgorithm.mikrise2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.HashMap


class NormalAlgorithmTest {

    @Test
    fun testReplaceRange() {
        val testedLine = "abcd"
        val oldValue = "ab"
        val newValue = "c"
        val startIndex = 0
        val expectedLine = "ccd"
        val notExpectedLine = "cd"
        val newLine = testedLine.replaceRange(startIndex, oldValue, newValue)
        assertEquals(expectedLine, newLine)
        assertNotEquals(notExpectedLine, newLine)
    }

    @Test
    fun testApplyNormalAlgorithm() {
        val line = "aabc"
        val map = HashMap<String, String>()
        map["a"] = "c"
        map["b"] = "c"
        val str = applyNormalAlgorithm(line, map)
        val expectedLine = "cccc"
        val notExpectedLine = "ccc"
        assertEquals(expectedLine, str)
        assertNotEquals(notExpectedLine, str)
    }

    @Test
    fun testFindReplaceParams() {
        val scanner = Scanner("a $REPLACEMENT_PARAMETER_SEPARATOR b")
        val map = findReplaceParams(scanner)
        val expectedMap = HashMap<String, String>()
        expectedMap["a"] = "b"
        assertEquals(expectedMap, map)
    }

    @Test
    fun testGetFirstLine() {
        val scanner = Scanner("abdadasd\n a > b")
        val expectedLine = "abdadasd"
        val notExpectedLine = "abdadasd a > b"
        val str = getFirstLine(scanner)
        assertEquals(expectedLine, str)
        assertNotEquals(notExpectedLine, str)

    }

    @Test
    fun testCheckOnLooping() {
        val map = HashMap<String, String>()
        map["a"] = "c"
        map["c"] = "a"
        val checker = checkOnLooping(map)
        val expectedVariable = true
        assertEquals(expectedVariable, checker)
    }

}