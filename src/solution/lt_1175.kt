package solution

import kotlin.math.floor
import kotlin.math.pow

private const val mod = 1e9.toInt() + 7

fun numPrimeArrangements(n: Int): Int {
    val prime = BooleanArray(n + 1) { true }
    for (i in 2..(floor(n.toDouble().pow(0.5)).toInt())) {
        if (prime[i]) {
            for (j in i.shl(1)..n step i) {
                prime[j] = false
            }
        }
    }
    val primes = prime.count { it } - 2
    return (primes.f() * (n - primes).f() % mod).toInt()
}

private fun Int.f(): Long {
    return (1..this).fold(1L) { acc, i -> acc * i % mod }
}