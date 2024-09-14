package cn_solution

fun reportSpam(message: Array<String>, bannedWords: Array<String>): Boolean {
    return bannedWords.toHashSet().let { s -> message.count { it in s } >= 2 }
}