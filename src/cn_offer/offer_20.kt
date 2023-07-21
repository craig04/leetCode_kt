package cn_offer

private const val ST_INIT = 0
private const val ST_SIGN = 1
private const val ST_INT = 2
private const val ST_DOT_ONLY = 3
private const val ST_DOT_WITH_INT = 4
private const val ST_DECIMAL = 5
private const val ST_EXP = 6
private const val ST_EXP_SIGN = 7
private const val ST_EXP_INT = 8
private const val ST_END = 9

private const val TYPE_SPACE = 0
private const val TYPE_SIGN = 1
private const val TYPE_DIGIT = 2
private const val TYPE_DOT = 3
private const val TYPE_EXPONENT = 4

private val TABLE = hashMapOf(
    ST_INIT to hashMapOf(
        TYPE_SPACE to ST_INIT,
        TYPE_SIGN to ST_SIGN,
        TYPE_DIGIT to ST_INT,
        TYPE_DOT to ST_DOT_ONLY,
    ),
    ST_SIGN to hashMapOf(
        TYPE_DIGIT to ST_INT,
        TYPE_DOT to ST_DOT_ONLY,
    ),
    ST_INT to hashMapOf(
        TYPE_SPACE to ST_END,
        TYPE_DIGIT to ST_INT,
        TYPE_DOT to ST_DOT_WITH_INT,
        TYPE_EXPONENT to ST_EXP,
    ),
    ST_DOT_ONLY to hashMapOf(
        TYPE_DIGIT to ST_DECIMAL,
    ),
    ST_DOT_WITH_INT to hashMapOf(
        TYPE_SPACE to ST_END,
        TYPE_DIGIT to ST_DECIMAL,
        TYPE_EXPONENT to ST_EXP,
    ),
    ST_DECIMAL to hashMapOf(
        TYPE_SPACE to ST_END,
        TYPE_DIGIT to ST_DECIMAL,
        TYPE_EXPONENT to ST_EXP,
    ),
    ST_EXP to hashMapOf(
        TYPE_SIGN to ST_EXP_SIGN,
        TYPE_DIGIT to ST_EXP_INT,
    ),
    ST_EXP_SIGN to hashMapOf(
        TYPE_DIGIT to ST_EXP_INT,
    ),
    ST_EXP_INT to hashMapOf(
        TYPE_SPACE to ST_END,
        TYPE_DIGIT to ST_EXP_INT,
    ),
    ST_END to hashMapOf(
        TYPE_SPACE to ST_END
    ),
)

fun isNumber(s: String): Boolean {
    var state = ST_INIT
    for (c in s) {
        val type = when (c) {
            ' ' -> TYPE_SPACE
            '+', '-' -> TYPE_SIGN
            in '0'..'9' -> TYPE_DIGIT
            '.' -> TYPE_DOT
            'e', 'E' -> TYPE_EXPONENT
            else -> -1
        }
        state = TABLE[state]?.get(type) ?: return false
    }
    return TABLE[state]?.get(TYPE_SPACE) == ST_END
}