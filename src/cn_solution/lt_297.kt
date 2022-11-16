package cn_solution

import base.TreeNode

class Codec_297() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val builder = StringBuilder()
        fun serialize(node: TreeNode?) {
            if (node == null) {
                builder.append("n ")
            } else {
                builder.append(node.`val`).append(' ')
                serialize(node.left)
                serialize(node.right)
            }
        }
        serialize(root)
        builder.setLength(builder.length - 1)
        return builder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var i = 0
        val nodes = data.split(' ')
        fun deserialize(): TreeNode? {
            val node = nodes[i++]
            if (node[0] == 'n')
                return null
            return TreeNode(node.toInt()).apply {
                left = deserialize()
                right = deserialize()
            }
        }
        return deserialize()
    }
}