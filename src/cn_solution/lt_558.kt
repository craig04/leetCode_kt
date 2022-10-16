package cn_solution

class Solution_558 {

    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }

    fun intersect(quadTree1: Node?, quadTree2: Node?): Node? {
        fun intersect(t1: Node, t2: Node): Node {
            return when {
                t1.isLeaf -> if (t1.`val`) t1 else t2
                t2.isLeaf -> if (t2.`val`) t2 else t1
                else -> {
                    val topLeft = intersect(t1.topLeft!!, t2.topLeft!!)
                    val topRight = intersect(t1.topRight!!, t2.topRight!!)
                    val bottomLeft = intersect(t1.bottomLeft!!, t2.bottomLeft!!)
                    val bottomRight = intersect(t1.bottomRight!!, t2.bottomRight!!)
                    if (topLeft.isLeaf && topRight.isLeaf
                        && bottomLeft.isLeaf && bottomRight.isLeaf
                        && topLeft.`val` == topRight.`val`
                        && topLeft.`val` == bottomLeft.`val`
                        && topLeft.`val` == bottomRight.`val`
                    ) {
                        Node(topLeft.`val`, true)
                    } else
                        Node(`val` = false, isLeaf = false).also {
                            it.topLeft = topLeft
                            it.topRight = topRight
                            it.bottomLeft = bottomLeft
                            it.bottomRight = bottomRight
                        }
                }
            }
        }
        return intersect(quadTree1!!, quadTree2!!)
    }
}