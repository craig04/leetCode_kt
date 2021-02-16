package solution

fun interpret(command: String): String {
    val sb = StringBuilder()
    var i = 0
    while (i != command.length) {
        when {
            command[i] == 'G' -> {
                sb.append('G')
                i++
            }
            command[i + 1] == ')' -> {
                sb.append('o')
                i += 2
            }
            else -> {
                sb.append("al")
                i += 4
            }
        }
    }
    return sb.toString()
}