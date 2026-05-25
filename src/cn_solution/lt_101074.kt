package cn_solution

fun passwordStrength(password: String): Int {
    val set = HashSet<Char>()
    return password.fold(0) { res, c ->
        res + when {
            !set.add(c) -> 0
            c.isLowerCase() -> 1
            c.isUpperCase() -> 2
            c.isDigit() -> 3
            else -> 5
        }
    }
}