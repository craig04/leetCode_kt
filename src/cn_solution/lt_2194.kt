package cn_solution

fun cellsInRange(s: String): List<String> {
    return (s[0]..s[3]).flatMap { r -> (s[1]..s[4]).map { c -> "$r$c" } }
}