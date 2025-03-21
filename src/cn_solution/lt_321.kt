package cn_solution

fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {

    fun subsequence(nums: IntArray, len: Int, res: IntArray) {
        var drop = nums.size - len
        var pos = -1
        for (num in nums) {
            while (drop > 0 && pos >= 0 && num > res[pos]) {
                drop--
                pos--
            }
            res[++pos] = num
        }
    }

    fun merge(a: IntArray, b: IntArray, n: Int, m: Int, res: IntArray) {
        var i = 0
        var j = 0
        var pos = -1
        while (i < n || j < m) {
            var x = i
            var y = j
            while (x < n && y < m && a[x] == b[y]) {
                x++
                y++
            }
            res[++pos] = if (x == n || (y != m && a[x] < b[y]))
                b[j++]
            else
                a[i++]
        }
    }

    val sub1 = IntArray(nums1.size)
    val sub2 = IntArray(nums2.size)
    val sub = IntArray(k)
    val ans = IntArray(k)
    for (len1 in maxOf(0, k - nums2.size)..minOf(nums1.size, k)) {
        val len2 = k - len1
        subsequence(nums1, len1, sub1)
        subsequence(nums2, len2, sub2)
        merge(sub1, sub2, len1, len2, sub)
        for (i in 0 until k) {
            if (sub[i] != ans[i]) {
                if (sub[i] > ans[i])
                    sub.copyInto(ans, i, i)
                break
            }
        }
    }
    return ans
}