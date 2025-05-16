package cn_solution

import java.util.*

fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    val n = words.size
    val len = IntArray(n)
    val pre = IntArray(n)
    for (i in 0 until n) {
        len[i] = 1
        pre[i] = -1
        for (j in 0 until i) {
            if (groups[i] == groups[j] || words[i].length != words[j].length)
                continue
            var dis = 0
            for (k in words[i].indices)
                if (words[i][k] != words[j][k])
                    if (++dis == 2)
                        break
            if (dis == 1 && len[j] + 1 > len[i]) {
                len[i] = len[j] + 1
                pre[i] = j
            }
        }
    }
    val ans = LinkedList<String>()
    var pos = len.indices.maxBy { len[it] }
    while (pos != -1) {
        ans.addFirst(words[pos])
        pos = pre[pos]
    }
    return ans
}