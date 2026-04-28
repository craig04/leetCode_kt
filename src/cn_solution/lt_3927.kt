package cn_solution

class Solution_3927 {

    companion object {

        const val MAX = 100000
        val factor = Array(MAX + 1) { ArrayList<Int>() }

        init {
            for (i in 1..MAX)
                for (j in i..MAX step i)
                    factor[j].add(i)
        }
    }

    fun minArraySum(nums: IntArray): Long {
        val set = nums.toHashSet()
        return nums.fold(0L) { ans, num ->
            ans + factor[num].first(set::contains)
        }
    }
}