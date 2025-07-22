package cn_solution

class Solution_3629 {

    companion object {

        const val N = 1000001
        val pfs = Array(N) { ArrayList<Int>() }

        init {
            for (i in 2 until N)
                if (pfs[i].isEmpty())
                    for (j in i until N step i)
                        pfs[j].add(i)
        }
    }

    fun minJumps(nums: IntArray): Int {
        val n = nums.size
        val to = HashMap<Int, ArrayList<Int>>()
        nums.forEachIndexed { i, num ->
            for (pf in pfs[num])
                to.computeIfAbsent(pf) { ArrayList() }.add(i)
        }
        val vis = BooleanArray(n)
        val q = ArrayDeque<Int>()
        vis[0] = true
        q.add(0)
        var ans = 0
        while (q.isNotEmpty()) {
            repeat(q.size) {
                val i = q.removeFirst()
                if (i == n - 1)
                    return ans
                val next = to[nums[i]] ?: ArrayList()
                next.add(i + 1)
                if (i != 0)
                    next.add(i - 1)
                for (j in next)
                    if (!vis[j]) {
                        vis[j] = true
                        q.add(j)
                    }
                next.clear()
            }
            ans++
        }
        return -1
    }
}