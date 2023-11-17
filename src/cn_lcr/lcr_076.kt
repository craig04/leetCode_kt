package cn_lcr

fun findKthLargest(nums: IntArray, k: Int): Int {
    val random = java.util.Random()
    fun swap(a: Int, b: Int) {
        val tmp = nums[a]
        nums[a] = nums[b]
        nums[b] = tmp
    }

    fun partition(l: Int, r: Int): Int {
        var p = random.nextInt(r - l + 1) + l
        swap(l, p)
        p = l
        val pivot = nums[l]
        for (i in l + 1..r)
            if (nums[i] < pivot)
                swap(++p, i)
        swap(p, l)
        return p
    }

    fun select(l: Int, r: Int, index: Int): Int {
        val pos = partition(l, r)
        return when {
            pos < index -> select(pos + 1, r, index)
            pos > index -> select(l, pos - 1, index)
            else -> nums[index]
        }
    }
    return select(0, nums.lastIndex, nums.size - k)
}