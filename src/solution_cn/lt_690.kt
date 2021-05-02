package solution_cn

class Employee {
    var id: Int = 0
    var importance: Int = 0
    var subordinates: List<Int> = listOf()
}

fun getImportance(employees: List<Employee?>, id: Int): Int {
    val map = employees.associateBy { it?.id }
    fun getImportance(id: Int): Int {
        return map[id]?.run {
            importance + subordinates.sumBy { getImportance(it) }
        } ?: 0
    }
    return getImportance(id)
}