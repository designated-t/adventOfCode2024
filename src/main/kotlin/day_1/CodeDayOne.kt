package org.designation.t.day_1

import java.io.File
import org.designation.t.getInput

class CodeDayOne {
    fun solve() {
        val fileContent = getInput(1)
        val listOfInputs = fileContent
            .map {
                val formattedInts = it.split(" ")
                    .filter { str -> str.isNotEmpty() }
                    .map { str -> str.toInt() }

                formattedInts[0] to formattedInts[1]
            }

        solveFirst(listOfInputs)
        solveSecond(listOfInputs)
    }

    private fun solveFirst(listOfInputs: List<Pair<Int, Int>>) {
        val splitInputs = listOfInputs.unzip()
        val splitMutableInputs = Pair(splitInputs.first.toMutableList(), splitInputs.second.toMutableList())
        val differences = mutableListOf<Int>()

        while (splitMutableInputs.first.isNotEmpty()) {
            val firstMin = splitMutableInputs.first.minOrNull()
            val secondMin = splitMutableInputs.second.minOrNull()
            val difference = getDifference(firstMin!!, secondMin!!)

            println("$firstMin - $secondMin = $difference")

            differences.add(difference)

            splitMutableInputs.first.remove(firstMin)
            splitMutableInputs.second.remove(secondMin)


        }

        println(differences.sum())
    }

    private fun solveSecond(listOfInputs: List<Pair<Int, Int>>) {}


    private fun getDifference(first: Int, second: Int): Int {
        val listForEase = listOf(first, second)
        return listForEase.max() - listForEase.min()
    }
}