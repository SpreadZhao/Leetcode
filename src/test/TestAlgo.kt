package test

import algo.InsertionSort
import algo.MergeSort

object TestAlgo {
    fun insertionSort() {
        val arr = intArrayOf(2, 3, 4, 5, 1)
        InsertionSort().sort(arr)
        arr.print()
    }
    fun mergeSort() {
        val arr = intArrayOf(5, 8, 6, 9, 7, 100, 23, 315, 12, 77, 55, 33)
        MergeSort().sort(arr)
        arr.print()
    }
    private fun IntArray.print() {
        forEach {
            print("$it ")
        }
        println()
    }
}