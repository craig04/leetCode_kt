package cn_solution

fun sumOfEncryptedInt(nums: IntArray): Int {
    return nums.sumOf { num ->
        var x = num
        var mul = 0
        var max = 0
        while (x != 0) {
            mul = mul * 10 + 1
            max = maxOf(max, x % 10)
            x /= 10
        }
        mul * max
    }
}