//package com.normAlgorifm.mikrise2
//
//import getNormAlgorifm
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test
//import java.util.ArrayList
//
//internal class NormalAlgoKtTest {
//    @Test
//    fun testNormAlgorifm() {
//        assertEquals(getNormAlgorifm(mutableListOf(Pair("ab", "b")) as ArrayList, "aab"), "b")
//        assertEquals(getNormAlgorifm(mutableListOf(Pair("ab", "b")) as ArrayList, "aaaabbbaba"), "bbbba")
//        assertEquals(
//            getNormAlgorifm(mutableListOf(Pair("ab", "s"), Pair("b", "c")) as ArrayList, "aabcabb"),
//            "ascacb"
//        )
//    }
//
//}