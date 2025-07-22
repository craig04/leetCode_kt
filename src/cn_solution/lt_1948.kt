package cn_solution

fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
    class Node(val name: String) {
        var idx = -1
        var del = false
        val sub = HashMap<String, Node>()
    }

    val root = Node("/")
    paths.forEachIndexed { idx, path ->
        path.fold(root) { node, name ->
            node.sub.computeIfAbsent(name) { Node(name) }
        }.idx = idx
    }
    val hash = HashMap<String, Node>()
    fun Node.dfs(): String {
        var s = ""
        if (sub.isNotEmpty()) {
            s = sub.values.mapTo(ArrayList()) { "(${it.dfs()})" }
                .apply { sort() }
                .joinToString(separator = "")
            val that = hash.put(s, this)
            if (that != null) {
                this.del = true
                that.del = true
            }
        }
        return "$s$name"
    }
    root.dfs()
    val ans = ArrayList<List<String>>()
    fun Node.filter() {
        if (del)
            return
        ans.add(paths[idx])
        sub.values.forEach(Node::filter)
    }
    root.sub.values.forEach(Node::filter)
    return ans
}