@file:JvmName("Main")

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val recordsFile = File("input.txt")
    val scan = Scanner(recordsFile)
    var word = ""
    val list: ArrayList<Pair<String, String>> = mutableListOf<Pair<String, String>>() as ArrayList<Pair<String, String>>
    if (scan.hasNextLine()) {
        word = scan.nextLine()
        if (!word.contains(">") && !word.contains(" ")) {

            while (scan.hasNextLine()) {
                val a = scan.next()
                scan.next()
                val b = scan.next()
                val pair = Pair(a, b)
                list.add(pair)
            }
            word = getNormAlgorifm(list, word)
        } else {
            println("Error")
        }
    } else {
        println("Error")
    }
    println(word)
}

fun getNormAlgorifm(list: ArrayList<Pair<String, String>>, wordVal: String): String {
    var word = wordVal
    var check = false
    while (!check) {
        list.forEach {
            if (word.indexOf(it.first) != -1 && !check) {
                word = word.substring(
                    0,
                    word.indexOf(it.first)
                ) + it.second + word.substring(word.indexOf(it.first) + it.first.length, word.length)
            } else {
                check = true

            }
        }
    }
    return word
}
