package cn_solution

fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
    val cnt = HashMap<Int, Int>()
    for (x in nums1)
        for (y in nums2)
            cnt.merge(x + y, 1) { a, b -> a + b }
    return nums3.sumOf { x -> nums4.sumOf { y -> cnt[-x - y] ?: 0 } }
}