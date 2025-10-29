package cn_solution

import kotlin.random.Random

class Codec() {

    val pool = ArrayList<Char>()
    val stol = HashMap<String, String>()
    val ltos = HashMap<String, String>()

    init {
        pool.addAll('a'..'z')
        pool.addAll('A'..'Z')
        pool.addAll('0'..'9')
    }

    private fun next() = buildString {
        repeat(6) { append(pool[Random.nextInt(pool.size)]) }
    }

    fun encode(longUrl: String): String {
        return ltos.computeIfAbsent(longUrl) {
            val shortUrl = "http://tinyurl.com/${next()}"
            stol[shortUrl] = longUrl
            shortUrl
        }
    }

    fun decode(shortUrl: String): String {
        return stol[shortUrl] ?: ""
    }
}