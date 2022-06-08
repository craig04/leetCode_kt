package cn_solution

fun numUniqueEmails(emails: Array<String>): Int {
    return emails.mapTo(HashSet()) {
        buildString {
            var i = 0
            while (it[i] != '@') {
                val c = it[i++]
                if (c == '+')
                    break
                else if (c != '.')
                    append(c)
            }
            for (j in it.indexOf('@', i) until it.length)
                append(it[j])
        }
    }.size
}