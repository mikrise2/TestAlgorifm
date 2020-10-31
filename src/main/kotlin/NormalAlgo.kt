@file:JvmName("Main")

import java.io.File
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class LineNotFoundException(override val message: String) : Exception(message)

fun main() {

    val recordsFile = File("input.txt")
    val scan = Scanner(recordsFile)

    val changedString = getFirstLine(scan)
    val replaceParams = findReplaceParams(scan)
    val newString = applyNormalAlgorithm(changedString, replaceParams)
    println(newString)
}

/**
 * ищет строку которую необходимо изменить
 *
 * @param scanner [Scanner] - A simple text scanner which can parse primitive types and strings using regular expressions.
 * @return возвращает строку которую необходимо изменить
 * @throws LineNotFoundException - когда строка не найдена
 */
fun getFirstLine(scanner: Scanner): String {
    if (!scanner.hasNextLine()) throw LineNotFoundException("Line .... not found exception")
    return scanner.nextLine()
}

fun findReplaceParams(scanner: Scanner): Map<String, String> {
    val map = HashMap<String, String>()
    if (scanner.hasNextLine()) {
        val replaceParam = scanner.nextLine()
        val arr = replaceParam.split(" > ")
        if (arr.size == 2) throw Exception()
        map[arr[0]] = arr[1]
    }
    return map
}

fun applyNormalAlgorithm(changedLine: String, replaceParams: Map<String, String>): String {
    var newLine = changedLine

    loop@ while (true) {
        for (param in replaceParams.entries) {
            val index = newLine.indexOf(param.key)
            if (index != -1) {
                newLine = newLine.replaceRange(index, param.key, param.value)
            } else {
                break@loop
            }
        }
    }
    return newLine
}

fun String.replaceRange(startIndex: Int, key: String, value: String): String =
    this.replaceRange(startIndex, startIndex + key.length, value)
