package solution

fun balancedStringSplit(s: String): Int {
    var left = 0
    return s.count { (if (it == 'L') ++left else --left) == 0 }
}