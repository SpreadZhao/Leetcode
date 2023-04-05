package questions

import kotlin.math.ceil
import kotlin.math.max

class MinimizeMaximumOfArray {
    fun minimizeArrayValue(nums: IntArray): Int {
        var res = 0L
        var sum = 0L
        for(i in nums.indices){
            sum += nums[i]
            res = max(res, ceil(sum / (i + 1).toDouble()).toLong())
        }
        return res.toInt()
    }
}