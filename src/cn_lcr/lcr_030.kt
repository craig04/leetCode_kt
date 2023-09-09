package cn_lcr

import kotlin.random.Random

class RandomizedSet() {

    private val numbers = ArrayList<Int>()
    private val indices = HashMap<Int, Int>()

    fun insert(`val`: Int): Boolean {
        val prev = indices.putIfAbsent(`val`, numbers.size)
        if (prev != null)
            return false
        numbers.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        val prev = indices.remove(`val`) ?: return false
        val last = numbers.removeLast()
        if (prev != numbers.size) {
            numbers[prev] = last
            indices[last] = prev
        }
        return true
    }

    fun getRandom(): Int {
        return numbers[Random.Default.nextInt(numbers.size)]
    }
}