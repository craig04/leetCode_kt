package cn_solution

import cn_solution.CharType.*
import cn_solution.Status.*

private enum class Status {
    INIT,
    BASE_SIGN,
    BASE_INT,
    BASE_DOT,
    BASE_HEAD_DOT,
    BASE_DEC,
    EXP_E,
    EXP_SIGN,
    EXP_INT
}

private enum class CharType {
    DIGIT,
    SIGN,
    EXP,
    DOT
}

private val typeMap = HashMap<Char, CharType>().apply {
    put('+', SIGN)
    put('-', SIGN)
    put('e', EXP)
    put('E', EXP)
    put('.', DOT)
    ('0'..'9').forEach { put(it, DIGIT) }
}

private val transfer = hashMapOf(
    INIT to hashMapOf(
        SIGN to BASE_SIGN,
        DOT to BASE_HEAD_DOT,
        DIGIT to BASE_INT
    ),
    BASE_SIGN to hashMapOf(
        DOT to BASE_HEAD_DOT,
        DIGIT to BASE_INT
    ),
    BASE_INT to hashMapOf(
        DOT to BASE_DOT,
        EXP to EXP_E,
        DIGIT to BASE_INT
    ),
    BASE_DOT to hashMapOf(
        EXP to EXP_E,
        DIGIT to BASE_DEC
    ),
    BASE_HEAD_DOT to hashMapOf(
        DIGIT to BASE_DEC
    ),
    BASE_DEC to hashMapOf(
        EXP to EXP_E,
        DIGIT to BASE_DEC
    ),
    EXP_E to hashMapOf(
        SIGN to EXP_SIGN,
        DIGIT to EXP_INT
    ),
    EXP_SIGN to hashMapOf(
        DIGIT to EXP_INT
    ),
    EXP_INT to hashMapOf(
        DIGIT to EXP_INT
    ),
)

fun isNumber(s: String): Boolean {
    var status = INIT
    for (c in s)
        status = typeMap[c]?.let { transfer[status]?.get(it) } ?: return false
    return status in listOf(BASE_INT, BASE_DOT, BASE_DEC, EXP_INT)
}