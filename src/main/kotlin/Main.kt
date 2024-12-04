package org.designation.t

import java.io.File
import org.designation.t.day_1.CodeDayOne
import org.designation.t.day_2.CodeDayTwo
import org.designation.t.day_3.CodeDayThree

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    CodeDayThree().solve()
}

fun getInput(day: Int) = File("src/main/kotlin/day_$day/input.txt").readLines()

fun Any?.print() = println(this)