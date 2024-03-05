package cn_solution

class MyHashSet() {

    private val n = 10013
    private val buckets = Array(n) { ArrayList<Int>() }

    fun add(key: Int) {
        val hash = key % n
        if (key !in buckets[hash])
            buckets[hash].add(key)
    }

    fun remove(key: Int) {
        val hash = key % n
        buckets[hash].remove(key)
    }

    fun contains(key: Int): Boolean {
        val hash = key % n
        return key in buckets[hash]
    }

}