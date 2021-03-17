package solution

fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
    val index = if (ruleKey == "type") 0 else if (ruleKey == "color") 1 else 2
    return items.count { it[index] == ruleValue }
}