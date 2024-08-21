package cn_solution

import java.util.*

class TweetCounts() {

    private val times = HashMap<String, TreeMap<Int, Int>>()

    fun recordTweet(tweetName: String, time: Int) {
        times.computeIfAbsent(tweetName) { TreeMap() }.merge(time, 1) { a, b -> a + b }
    }

    fun getTweetCountsPerFrequency(freq: String, tweetName: String, startTime: Int, endTime: Int): List<Int> {
        val len = when (freq) {
            "minute" -> 60
            "hour" -> 3600
            else -> 86400
        }
        val ans = ArrayList<Int>()
        for (i in 0 until (endTime - startTime) / len + 1)
            ans.add(0)
        val map = times[tweetName] ?: return ans
        var e = map.ceilingEntry(startTime)
        while (e != null && e.key <= endTime) {
            val idx = (e.key - startTime) / len
            ans[idx] += e.value
            e = map.higherEntry(e.key)
        }
        return ans
    }
}