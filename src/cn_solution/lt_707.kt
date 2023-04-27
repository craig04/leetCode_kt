package cn_solution

class MyLinkedList() {

    class Node(val n: Int, var next: Node? = null, var prev: Node? = null)

    private val head = Node(0)
    private val tail = Node(0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(index: Int): Int {
        var temp = head
        repeat(index + 1) { temp = temp.next ?: return -1 }
        return if (temp == tail) -1 else temp.n
    }

    fun addAtHead(`val`: Int) {
        val next = head.next
        val node = Node(`val`, next, head)
        head.next = node
        next?.prev = node
    }

    fun addAtTail(`val`: Int) {
        val prev = tail.prev
        val node = Node(`val`, tail, prev)
        tail.prev = node
        prev?.next = node
    }

    fun addAtIndex(index: Int, `val`: Int) {
        var temp = head
        repeat(maxOf(0, index)) { temp = temp.next ?: return }
        if (temp == tail)
            return
        val next = temp.next
        val node = Node(`val`, next, temp)
        temp.next = node
        next?.prev = node
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0)
            return
        var temp = head
        repeat(index + 1) { temp = temp.next ?: return }
        if (temp == tail)
            return
        temp.next?.prev = temp.prev
        temp.prev?.next = temp.next
    }
}