package cn_solution

const val INIT = 0
const val DOLLAR = 1
const val PRICE = 2
const val OTHER = 3

fun discountPrices(sentence: String, discount: Int): String {
    val sb = StringBuilder()
    var status = INIT
    var price = 0L
    for (c in sentence) {
        when (status) {
            INIT -> {
                status = if (c == '$') DOLLAR else OTHER
            }

            DOLLAR -> {
                if (c in '0'..'9') {
                    price = (c - '0').toLong()
                    status = PRICE
                } else {
                    status = if (c == ' ') INIT else OTHER
                }
            }

            PRICE -> {
                if (c in '0'..'9') {
                    price = c - '0' + price * 10
                } else if (c == ' ') {
                    sb.append(String.format("%.2f", price / 100.0 * (100 - discount)))
                    status = INIT
                } else {
                    sb.append(price)
                    status = OTHER
                }
            }

            OTHER -> {
                if (c == ' ') {
                    status = INIT
                }
            }
        }
        if (status != PRICE)
            sb.append(c)
    }
    if (status == PRICE) {
        sb.append(String.format("%.2f", price / 100.0 * (100 - discount)))
    }
    return sb.toString()
}