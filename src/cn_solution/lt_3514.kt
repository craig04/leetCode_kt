package cn_solution

private fun uniqueXorTriplets(nums: IntArray): Int {
    val a = BooleanArray(2048)
    for (x in nums)
        for (y in nums)
            a[x xor y] = true
    val b = BooleanArray(2048)
    for (x in nums)
        for (y in a.indices)
            if (a[y])
                b[x xor y] = true
    return b.count { it }
}