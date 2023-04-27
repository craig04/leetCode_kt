package cn_solution

import base.NestedInteger
import java.util.*

class NestedIterator(nestedList: List<NestedInteger>) {

    class Node(val list: List<NestedInteger>, var index: Int) {
        val curNestedInteger = list[index]
    }

    private val stack = Stack<Node>().apply {
        push(Node(nestedList, -1))
        seek()
    }

    private fun Stack<Node>.seek() {
        while (!isEmpty()) {
            val top = peek()
            if (++top.index == top.list.size) {
                pop()
            } else if (top.curNestedInteger.isInteger()) {
                break
            } else {
                push(Node(top.curNestedInteger.getList() ?: emptyList(), -1))
            }
        }
    }

    fun next(): Int {
        val result = stack.peek().curNestedInteger.getInteger() ?: 0
        stack.seek()
        return result
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }
}