package cn_solution

class ThroneInheritance(private val kingName: String) {

    private val children = HashMap<String, ArrayList<String>>()
    private val dead = HashSet<String>()

    fun birth(parentName: String, childName: String) {
        children.computeIfAbsent(parentName) { ArrayList() }.add(childName)
    }

    fun death(name: String) {
        dead.add(name)
    }

    fun getInheritanceOrder(): List<String> {
        val result = ArrayList<String>()
        fun dfs(cur: String) {
            if (cur !in dead)
                result.add(cur)
            children[cur]?.forEach { dfs(it) }
        }
        dfs(kingName)
        return result
    }

}