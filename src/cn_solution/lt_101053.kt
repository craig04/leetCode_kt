package cn_solution

    fun minCost(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val left = IntArray(n) { 1 }
        val right = IntArray(n) { 1 }
        for (i in 1 until n - 1) {
            val x = nums[i]
            val l = x - nums[i - 1]
            val r = nums[i + 1] - x
            if (l <= r)
                right[i + 1] = r
            else
                left[i - 1] = l
        }
        for (i in 1 until n) {
            right[i] += right[i - 1]
            left[n - i - 1] += left[n - i]
        }
        return IntArray(queries.size) {
            val (l, r) = queries[it]
            if (l < r)
                right[r] - right[l]
            else
                left[r] - left[l]
        }
    }