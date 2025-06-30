package cn_solution

fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
    val business = hashSetOf("electronics", "grocery", "pharmacy", "restaurant")
    fun validName(name: String) =
        name.isNotEmpty() && name.all { c -> c.isLetterOrDigit() || c == '_' }
    return code.indices
        .filter { validName(code[it]) && businessLine[it] in business && isActive[it] }
        .sortedWith(compareBy({ businessLine[it] }, { code[it] }))
        .map { code[it] }
}