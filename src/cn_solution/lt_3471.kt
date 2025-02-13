package cn_solution

fun largestInteger(nums: IntArray, k: Int): Int {
    return when (k) {
        1 -> {
            val map = HashMap<Int, Int>()
            nums.forEach { map.merge(it, 1, Int::plus) }
            var ans = -1
            for ((num, cnt) in map)
                if (cnt == 1)
                    ans = maxOf(ans, num)
            ans
        }
        nums.size -> {
            nums.max()
        }
        else -> {
            var x = 0
            var y = 0
            for (num in nums) {
                if (num == nums.first())
                    x++
                else if (num == nums.last())
                    y++
                if (x > 1 && y > 1)
                    break
            }
            var ans = -1
            if (x == 1)
                ans = nums.first()
            if (y == 1)
                ans = maxOf(ans, nums.last())
            ans
        }
    }
}