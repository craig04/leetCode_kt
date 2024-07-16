package cn_solution

import java.util.*

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {

    private val shops = Array(n) { HashMap<Int, IntArray>() }
    private val inventory = HashMap<Int, TreeSet<IntArray>>()
    private val rented = TreeSet<IntArray>(compareBy({ it[2] }, { it[0] }, { it[1] }))

    init {
        for (e in entries) {
            shops[e[0]][e[1]] = e
            inventory.computeIfAbsent(e[1]) { TreeSet(compareBy({ it[2] }, { it[0] })) }.add(e)
        }
    }

    fun search(movie: Int): List<Int> {
        val ans = ArrayList<Int>()
        val entries = inventory[movie] ?: emptySet()
        for (e in entries) {
            ans.add(e[0])
            if (ans.size == 5)
                break
        }
        return ans
    }

    fun rent(shop: Int, movie: Int) {
        val e = shops[shop][movie] ?: return
        inventory[e[1]]?.remove(e)
        rented.add(e)
    }

    fun drop(shop: Int, movie: Int) {
        val e = shops[shop][movie] ?: return
        inventory[e[1]]?.add(e)
        rented.remove(e)
    }

    fun report(): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        for (e in rented) {
            ans.add(listOf(e[0], e[1]))
            if (ans.size == 5)
                break
        }
        return ans
    }
}