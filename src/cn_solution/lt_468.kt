package cn_solution

fun validIPAddress(queryIP: String): String {
    if (queryIP.contains('.')) {
        val seg = queryIP.split('.')
        return if (seg.size == 4 && seg.all {
                (it.length == 1 || (it.length in 2..3 && it[0] != '0'))
                        && it.all { c -> c.isDigit() }
                        && it.toInt() in 0..255
            }) "IPv4" else "Neither"
    }
    if (queryIP.contains(':')) {
        val seg = queryIP.split(':')
        return if (seg.size == 8 && seg.all {
                it.length in 1..4 && it.all { c ->
                    c in '0'..'9' || c in 'a'..'f' || c in 'A'..'F'
                }
            }) "IPv6" else "Neither"
    }
    return "Neither"
}