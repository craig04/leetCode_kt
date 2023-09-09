package cn_solution

class LockingTree(private val parent: IntArray) {

    private val n = parent.size
    private val locker = IntArray(n)
    private val children = Array(n) { ArrayList<Int>() }

    init {
        (1 until n).forEach {
            children[parent[it]].add(it)
        }
    }

    fun lock(num: Int, user: Int): Boolean {
        return update(num, 0, user)
    }

    fun unlock(num: Int, user: Int): Boolean {
        return update(num, user, 0)
    }

    private fun update(num: Int, old: Int, new: Int): Boolean {
        if (locker[num] != old)
            return false
        locker[num] = new
        return true
    }

    fun upgrade(num: Int, user: Int): Boolean {
        var node = num
        while (node != -1) {
            if (locker[node] != 0)
                return false
            node = parent[node]
        }
        var upgraded = false
        fun dfs(node: Int) {
            upgraded = upgraded.or(locker[node] != 0)
            locker[node] = 0
            children[node].forEach { dfs(it) }
        }
        dfs(num)
        if (upgraded)
            locker[num] = user
        return upgraded
    }
}