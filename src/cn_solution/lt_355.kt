package cn_solution

import java.util.*
import kotlin.collections.ArrayDeque

class Twitter() {

    private val f = HashMap<Int, HashSet<Int>>()
    private val p = HashMap<Int, ArrayDeque<IntArray>>()
    private var time = 0

    fun postTweet(userId: Int, tweetId: Int) {
        val q = p.computeIfAbsent(userId) { ArrayDeque() }
        if (q.size == 10)
            q.removeLast()
        q.addFirst(intArrayOf(++time, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val q = PriorityQueue<Pair<ArrayDeque<IntArray>, Int>> { l, r ->
            r.first[r.second][0] - l.first[l.second][0]
        }
        for (user in f[userId] ?: emptySet())
            p[user]?.let { q.add(Pair(it, 0)) }
        p[userId]?.let { q.add(Pair(it, 0)) }
        val ans = ArrayList<Int>()
        while (ans.size != 10 && q.isNotEmpty()) {
            val (c, i) = q.poll()
            if (i != c.lastIndex)
                q.offer(Pair(c, i + 1))
            ans.add(c[i][1])
        }
        return ans
    }

    fun follow(followerId: Int, followeeId: Int) {
        f.computeIfAbsent(followerId) { HashSet() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        f[followerId]?.remove(followeeId)
    }
}