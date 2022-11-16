package cn_solution

fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
    var result = 0
    var j = nums2.lastIndex
    for (i in nums1.indices.reversed()) {
        while (j >= 0 && nums1[i] > nums2[j])
            j--
        if (j < 0) break
        result = maxOf(result, j - i)
    }
    return result
}
