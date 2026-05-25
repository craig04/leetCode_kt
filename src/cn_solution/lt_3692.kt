package cn_solution

fun majorityFrequencyGroup(s: String): String {
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    val freq = IntArray(s.length + 1)
    var majority = 0
    var max = 0
    for (t in cnt)
        if (t != 0 && ++freq[t] > majority || freq[t] == majority && t > max) {
            majority = freq[t]
            max = t
        }
    val sb = StringBuilder()
    for (i in cnt.indices)
        if (cnt[i] == max)
            sb.append('a' + i)
    return sb.toString()
}