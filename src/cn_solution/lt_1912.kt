package cn_solution

import java.util.*

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {

    class Entry(val shop: Int, val movie: Int, val price: Int)

    private val table = Array(n) { HashMap<Int, Entry>() }
    private val inventory = HashMap<Int, PriorityQueue<Entry>>()
    private val rented = PriorityQueue<Entry> { a, b ->
        when {
            a.price != b.price -> a.price - b.price
            a.shop != b.shop -> a.shop - b.shop
            else -> a.movie - b.movie
        }
    }

    init {
        for ((shop, movie, price) in entries) {
            val entry = Entry(shop, movie, price)
            this.table[shop][movie] = entry
            this.inventory.computeIfAbsent(movie) {
                PriorityQueue { a, b ->
                    if (a.price != b.price) a.price - b.price else a.shop - b.shop
                }
            }.add(entry)
        }
    }

    fun search(movie: Int): List<Int> {
        val ans = ArrayList<Entry>()
        val entries = inventory[movie] ?: return emptyList()
        while (ans.size < 5 && entries.isNotEmpty()) {
            val e = entries.poll()
            if (e == table[e.shop][e.movie])
                ans.add(e)
        }
        entries.addAll(ans)
        return ans.map { it.shop }
    }

    fun rent(shop: Int, movie: Int) {
        val old = table[shop][movie] ?: return
        val new = Entry(shop, movie, old.price)
        table[shop][movie] = new
        rented.add(new)
    }

    fun drop(shop: Int, movie: Int) {
        val old = table[shop][movie] ?: return
        val new = Entry(shop, movie, old.price)
        table[shop][movie] = new
        inventory[movie]?.add(new)
    }

    fun report(): List<List<Int>> {
        val ans = ArrayList<Entry>()
        while (ans.size < 5 && rented.isNotEmpty()) {
            val e = rented.poll()
            if (e == table[e.shop][e.movie])
                ans.add(e)
        }
        rented.addAll(ans)
        return ans.map { listOf(it.shop, it.movie) }
    }
}