package cn_solution

fun trafficSignal(timer: Int): String {
    return when (timer) {
        0 -> "Green"
        30 -> "Orange"
        in 31..90 -> "Red"
        else -> "Invalid"
    }
}