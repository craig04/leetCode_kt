package cn_solution

class Solution_116 {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    private fun connect(root: Node?): Node? {
        var leftmost = root
        while (leftmost != null) {
            var head = leftmost
            while (head != null) {
                head.left?.next = head.right
                head.right?.next = head.next?.left
                head = head.next
            }
            leftmost = leftmost.left
        }
        return root
    }
}