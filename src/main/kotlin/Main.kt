package org.designation.t

import java.io.File
import org.designation.t.day_1.CodeDayOne

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    CodeDayOne().solve()
}

fun getInput(day: Int) = File("src/main/kotlin/day_$day/input.txt").readLines()