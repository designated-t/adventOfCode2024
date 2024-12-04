package org.designation.t.day_2

import javax.swing.text.Segment
import org.designation.t.getInput

typealias Report = List<Int>

class CodeDayTwo {
    fun solve() {
        val input = getInput(2)
        val formattedInputs = input.map { line -> line.split(" ").filter { it.isNotEmpty() }.map { it.toInt() } }

        solveFirst(formattedInputs)
        solveSecond(formattedInputs)

    }


    private fun solveFirst(formattedInputs: List<List<Int>>) {
        var sum = 0
        formattedInputs.forEach { report ->
            try {
                validateReport(report)
                sum++
            } catch (_: IllegalArgumentException) {}
        }

        println("Day 2 Part 1: $sum")
    }

    private fun solveSecond(reports: List<List<Int>>) {
        val unsafeReports = mutableListOf<List<Int>>()
        var sum = 0
        reports.forEach { report ->
            try {
                validateReport(report)
                sum++
            } catch (e: IllegalArgumentException) {
                unsafeReports.add(report)
            }
        }

        unsafeReports.forEach { unsafeReport ->
            unsafeReport.forEachIndexed { index, item ->
                val mutableReport = unsafeReport.toMutableList()
                mutableReport.removeAt(index)
                try {
                    validateReport(mutableReport)
                    sum++
                    return@forEach
                } catch (_: IllegalArgumentException) {
                }
            }
        }

        println("Day 2 Part 2: $sum")
    }

    private fun validateReport(report: Report) {
        var selectedSegment: Segment? = null
        report.forEachIndexed { innerIndex, item ->
            if (innerIndex == 0) {
                selectedSegment = nextSegment(report, innerIndex)
                if (selectedSegment == null)
                    throw IllegalArgumentException()
            }

            if (innerIndex < (report.size - 1)) {
                val newSegment = nextSegment(report, innerIndex)
                if (!isWithinValidDifference(report[innerIndex + 1], item) || newSegment != selectedSegment)
                    throw IllegalArgumentException()
            }
        }
    }

    private fun isWithinValidDifference(first: Int, second: Int): Boolean =
        listOf(first, second).let { (it.max() - it.min()) in 1..3 }

    private fun nextSegment(list: List<Int>, index: Int): Segment? =
        list[index].let {
            val next = list[index + 1]
            return when {
                next > it -> Segment.INCREASING
                next < it -> Segment.DECREASING
                else -> null
            }
        }

    enum class Segment {
        INCREASING,
        DECREASING,

        ;
    }
}
