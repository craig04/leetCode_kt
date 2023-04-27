package cn_solution

class Solution_138 {

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {

        var temp = node
        while (temp != null) {
            val next = temp.next
            val copy = Node(temp.`val`)
            temp.next = copy
            copy.next = next
            temp = next
        }
        temp = node
        while (temp != null) {
            val next = temp.next ?: break
            next.random = temp.random?.next
            temp = next.next
        }
        temp = node
        val copy = temp?.next
        while (temp != null) {
            val next = temp.next ?: break
            temp.next = next.next
            temp = temp.next
            next.next = temp?.next
        }
        return copy
    }
}