package test

import algo.*

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

    fun maximumSubarray() {
        val arr = intArrayOf(-2, 11, -4, 13, -5, -2)
        println(MaximumSubarray().maxSumDivideConquer(arr))
    }

    fun maxHeap() {
        val arr = intArrayOf(2, 5, 7, 1, 8, 13, 14)
        val arr2 = intArrayOf(9, 8, 6, 5, 7, 1, 0)
        val heap1 = MaxHeap().setArray(arr).build()
        val heap2 = MaxHeap().setArray(arr).buildRecursive()
        heap1.apply {
            print("heap1: ")
            print()
        }
        heap2.apply {
            print("heap2: ")
            print()
        }
        val pq = PriorityQueue(heap1)
        pq.update(5, 9)
        pq.apply {
            print("pq: ")
            print()
            print("pqHeap: ")
            printHeap()
        }
        pq.enqueue(12)
        pq.apply {
            println("after insertion:")
            print("pq: ")
            print()
            print("pqHeap: ")
            printHeap()
        }
    }

    fun quickSort() {
        val arr = intArrayOf(3, 56, 4, 6, 8, 4, 35, 33, 22, 66, 77, 2, 1, 6, 9)
        QuickSort().sort(arr)
        arr.forEach {
            print("$it ")
        }
        println()
    }

    private fun IntArray.print() {
        forEach {
            print("$it ")
        }
        println()
    }
}