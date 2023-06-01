package algo

class QuickSort {
    fun sort(arr: IntArray) {
        core(arr, 0, arr.lastIndex)
    }

    private fun core(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pivot = partition(arr, low, high)
            core(arr, low, pivot - 1)
            core(arr, pivot + 1, high)
        }
    }

    private fun partition(arr: IntArray, llow: Int, hhigh: Int): Int {
        var low = llow; var high = hhigh; val pivot = arr[low]
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--
            swap(arr, low, high)
            while (low < high && arr[low] <= pivot) low++
            swap(arr, low, high)
        }
        return low
    }

    private fun swap(arr: IntArray, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }
}