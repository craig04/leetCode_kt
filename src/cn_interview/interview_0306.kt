package cn_interview

import java.util.*

class AnimalShelf() {

    private val empty = intArrayOf(-1, -1)
    private val animals = Array(2) { LinkedList<IntArray>() }

    fun enqueue(animal: IntArray) {
        animals[animal[1]].addLast(animal)
    }

    fun dequeueAny(): IntArray {
        val cat = animals[0].firstOrNull()
        val dog = animals[1].firstOrNull()
        return when {
            dog == null -> if (cat == null) empty else dequeueCat()
            dog[0] > (cat?.get(0) ?: Int.MAX_VALUE) -> dequeueCat()
            else -> dequeueDog()
        }
    }

    fun dequeueDog(): IntArray {
        return dequeue(1)
    }

    fun dequeueCat(): IntArray {
        return dequeue(0)
    }

    private fun dequeue(index: Int): IntArray {
        return if (animals[index].isEmpty()) empty else animals[index].removeFirst()
    }
}