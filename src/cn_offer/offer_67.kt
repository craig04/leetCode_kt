package cn_offer

private enum class State { INIT, SIGN, NUMBER, END }
private enum class Type { SPACE, SIGN, NUMBER, OTHERS }

private val TABLE = arrayOf(
    arrayOf(State.INIT, State.SIGN, State.NUMBER, State.END),
    arrayOf(State.END, State.END, State.NUMBER, State.END),
    arrayOf(State.END, State.END, State.NUMBER, State.END),
)

fun strToInt(str: String): Int {
    var state = State.INIT
    var sign = 1
    var value = 0L
    for (c in str) {
        val type = when (c) {
            ' ' -> Type.SPACE
            '+', '-' -> Type.SIGN
            in '0'..'9' -> Type.NUMBER
            else -> Type.OTHERS
        }
        state = TABLE[state.ordinal][type.ordinal]
        when (state) {
            State.INIT -> continue
            State.SIGN -> if (c == '-') sign = -1
            State.END -> break
            State.NUMBER -> {
                value = c - '0' + value * 10
                if (sign == 1 && value >= Int.MAX_VALUE)
                    return Int.MAX_VALUE
                else if (sign == -1 && -value <= Int.MIN_VALUE)
                    return Int.MIN_VALUE
            }
        }
    }
    return (value * sign).toInt()
}