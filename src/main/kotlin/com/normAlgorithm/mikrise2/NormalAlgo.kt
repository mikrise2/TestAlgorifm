@file:JvmName("Main")

package com.normAlgorithm.mikrise2

import java.io.File
import java.util.*
import kotlin.collections.HashMap

class LineNotFoundException(override val message: String) : Exception(message)
class FileDoesnNotExistException(override val message: String) : Exception(message)
class EmptyArgsException(override val message: String) : Exception(message)

const val QUANTITY_OF_ELEMENTS_IN_ONE_CHANGE = 2
const val REPLACEMENT_PARAMETER_SEPARATOR = ">"

/** start method
 *
 * @throws FileDoesnNotExistException - when file doesn't exists.
 * @throws EmptyArgsException - when args are empty
 */
fun main(args: Array<String>) {
    if(args.isEmpty()) throw EmptyArgsException("Args are empty")
    val recordsFile = File(args[0])
    if (!recordsFile.exists()) throw FileDoesnNotExistException("File ${args[0]} doesn't exist")
    val scan = Scanner(recordsFile)

    val changedString = getFirstLine(scan)
    val replaceParams = findReplaceParams(scan)
    if (checkOnLooping(replaceParams)) println("algorithm is looping") else {
        val newString = applyNormalAlgorithm(changedString, replaceParams)
        print(newString)
    }
}

/**
 *looks for looping in algorithm.
 *
 * @param parameters [Map] - line modification options.
 * @return true if algorithm is looping and false if algorithm isn't looping.
 */
fun checkOnLooping(parameters: Map<String, String>): Boolean {
    val firstKey = parameters.keys.toList()[0]
    var lineForCheckOnLooping = firstKey
    for (param in parameters.entries) {
        val indexStartOfChange = lineForCheckOnLooping.indexOf(param.key)
        if (indexStartOfChange != -1) {
            lineForCheckOnLooping = lineForCheckOnLooping.replaceRange(indexStartOfChange, param.key, param.value)
        } else {
            break
        }
    }
    return lineForCheckOnLooping.contains(firstKey)

}

/**
 *looks for a line to be changed.
 *
 * @param scanner [Scanner] - A simple text scanner which can parse primitive types and strings using regular expressions.
 * @return returns the string to be changed.
 * @throws LineNotFoundException - when string doesn't found.
 */
fun getFirstLine(scanner: Scanner): String {
    if (!scanner.hasNextLine()) throw LineNotFoundException("Word for change doesn't found exception")
    return scanner.nextLine()
}

/**
 *looks for an element that needs to be replaced, and the corresponding element with which it needs to be replaced.
 *
 * @param scanner [Scanner] - A simple text scanner which can parse primitive types and strings using regular expressions.
 * @return returns [Map] - the key is the element to be replaced, and the value is the element to be replaced.
 * @throws LineNotFoundException - when string doesn't found.
 */
fun findReplaceParams(scanner: Scanner): Map<String, String> {
    val mapOfParameters = HashMap<String, String>()
    while (scanner.hasNextLine()) {
        val replaceParam = scanner.nextLine()
        val arrayOfElementsInOneChange = replaceParam.split(" $REPLACEMENT_PARAMETER_SEPARATOR ")
        if (arrayOfElementsInOneChange.size != QUANTITY_OF_ELEMENTS_IN_ONE_CHANGE) throw LineNotFoundException(
            "Not the right syntax of parameters exception"
        )
        mapOfParameters[arrayOfElementsInOneChange[0]] = arrayOfElementsInOneChange[1]
    }
    return mapOfParameters
}

/**
 *performs 1 iteration of the normal algorithm.
 *
 * @param changedLine [String] - string, what will be changed.
 * @param replaceParams [Map] - line modification options.
 * @return returns [String] - line after 1 iteration.
 */

fun applyNormalAlgorithm(changedLine: String, replaceParams: Map<String, String>): String {
    var newLine = changedLine

    loop@ while (true) {
        for (param in replaceParams.entries) {
            val indexStartOfChange = newLine.indexOf(param.key)
            if (indexStartOfChange != -1) {
                newLine = newLine.replaceRange(indexStartOfChange, param.key, param.value)
            } else {
                break@loop
            }
        }
    }
    return newLine
}


/**
 * changes a part of [String] for other [String].
 *
 * @param startIndex - char index , with which we start replacing.
 * @param key - [String], what we will remove [String].
 * @param key - [String], what we will insert [String].
 * @return returns [String] - updated string.
 */
fun String.replaceRange(startIndex: Int, key: String, value: String): String =
    this.replaceRange(startIndex, startIndex + key.length, value)
