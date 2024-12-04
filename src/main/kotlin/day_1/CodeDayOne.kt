package org.designation.t.day_1

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
        val (left, right) = Pair(splitInputs.first.toMutableList(), splitInputs.second.toMutableList())
        val differences = mutableListOf<Int>()

        while (left.isNotEmpty()) {
            val leftMin = left.minOrNull()
            val rightMin = right.minOrNull()
            val difference = getDifference(leftMin!!, rightMin!!)

            differences.add(difference)

            left.remove(leftMin)
            right.remove(rightMin)
        }

        println(differences.sum())
    }

    private fun solveSecond(listOfInputs: List<Pair<Int, Int>>) {
        val (left, right) = listOfInputs.unzip()
        var sum = 0

        left.asSequence().forEach { input ->
            sum += (input * right.filter { it == input }.size)
        }

        println(sum)
    }


    private fun getDifference(first: Int, second: Int): Int {
        val listForEase = listOf(first, second)
        return listForEase.max() - listForEase.min()
    }
}