package cn_solution

class Solution_133 {

    class Node(var `val`: Int) {
        var neighbors = ArrayList<Node?>()
    }

    fun cloneGraph(node: Node?): Node? {
        val map = HashMap<Node, Node>()
        fun Node?.clone(): Node? {
            this ?: return null
            var result = map[this]
            if (result != null)
                return result
            result = Node(`val`)
            map[this] = result
            neighbors.forEach { result.neighbors.add(it.clone()) }
            return result
        }
        return node.clone()
    }
}