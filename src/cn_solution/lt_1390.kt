package cn_solution

fun sumFourDivisors(nums: IntArray): Int {
    var ans = 0
    loop@ for (num in nums) {
        var cnt = 0
        var sum = 0
        var i = 1
        while (i * i < num) {
            if (num % i == 0) {
                if (++cnt > 2)
                    continue@loop
                sum += i + num / i
            }
            i++
        }
        if (i * i != num && cnt == 2)
            ans += sum
    }
    return ans
}