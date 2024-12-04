package org.designation.t.day_3

import org.designation.t.getInput
import org.designation.t.print

class CodeDayThree {
    private val itemDigitPattern = Regex("\\d+")

    fun solve() {
        val inputLines = getInput(3)
        val mulPattern = Regex("mul\\(\\d+,\\d+\\)")
        val mulDoDontPattern = Regex("mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)")

        solve(inputLines, mulPattern)
        solve(inputLines, mulDoDontPattern)
    }

    private fun solve(inputLines: List<String>, pattern: Regex) {
        val muls = mutableListOf<String>()
        var shouldReadMuls = true // must persist through lines
        inputLines.map { line ->
            pattern
                .findAll(line)
                .map { it.value }
                .forEach { lineResult ->
                    when {
                        lineResult.contains("mul") -> if (shouldReadMuls) muls.add(lineResult)
                        lineResult == "don't()" -> shouldReadMuls = false
                        lineResult == "do()" -> shouldReadMuls = true
                    }
                }
        }

        muls.asSequence()
            .map { processMul(it) }
            .reduce { sum, product -> sum + product }.print()
    }

    private fun processMul(mul: String): Int {
        val resultFactors = itemDigitPattern.findAll(mul)
            .map { it.value.toInt() }
            .toList()
        return resultFactors[0] * resultFactors[1]
    }
}
