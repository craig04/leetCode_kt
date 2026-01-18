package cn_solution

import java.util.*

class AuctionSystem() {

    val bids = HashMap<Int, Int>()
    val qs = HashMap<Int, PriorityQueue<IntArray>>()

    fun addBid(userId: Int, itemId: Int, bidAmount: Int) {
        bids[getKey(userId, itemId)] = bidAmount
        qs.computeIfAbsent(itemId) {
            PriorityQueue<IntArray> { (a, b), (c, d) -> if (a == c) d - b else c - a }
        }.add(intArrayOf(bidAmount, userId))
    }

    fun updateBid(userId: Int, itemId: Int, newAmount: Int) {
        addBid(userId, itemId, newAmount)
    }

    fun removeBid(userId: Int, itemId: Int) {
        bids.remove(getKey(userId, itemId))
    }

    fun getHighestBidder(itemId: Int): Int {
        val q = qs[itemId] ?: return -1
        while (q.isNotEmpty()) {
            val (bid, userId) = q.peek()
            if (bids[getKey(userId, itemId)] == bid)
                return userId
            q.poll()
        }
        return -1
    }

    fun getKey(userId: Int, itemId: Int): Int = userId.shl(16) + itemId
}