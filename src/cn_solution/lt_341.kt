package cn_solution

import java.util.*

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int)

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger)

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}

class NestedIterator(nestedList: List<NestedInteger>) {

    private class Node(val list: List<NestedInteger>, var index: Int) {
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