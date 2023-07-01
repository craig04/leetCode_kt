package cn_interview

class Operations() {

    private fun Int.negate(): Int {
        fun construct(init: Int): Int {
            var remain = this
            var result = 0
            var base = init
            while (remain != 0) {
                val next = remain + base
                if ((next > 0 && base > 0) || (next < 0 && base < 0)) {
                    base = init
                } else {
                    remain = next
                    result += base
                    base += base
                }
            }
            return result
        }
        return when {
            this == 0 || this == Int.MIN_VALUE -> this
            this > 0 -> construct(Int.MAX_VALUE + Int.MIN_VALUE)
            else -> construct(1)
        }
    }

    fun minus(a: Int, b: Int): Int {
        return a + b.negate()
    }

    fun multiply(a: Int, b: Int): Int {
        if (a == 0 || b == 0)
            return 0
        if (b == Int.MIN_VALUE)
            return minus(multiply(a, b + 1), a)
        if (b < 0)
            return multiply(a, b.negate()).negate()
        var remain = b.negate()
        var times = 1
        var base = a
        var result = 0
        while (remain != 0) {
            val next = remain + times
            if (next > 0) {
                times = 1
                base = a
            } else {
                remain = next
                result += base
                times += times
                base += base
            }
        }
        return result
    }

    fun divide(a: Int, b: Int): Int {
        if (a == 0)
            return 0
        if (b == Int.MIN_VALUE)
            return if (a == Int.MIN_VALUE) 1 else 0
        if (b < 0)
            return divide(a, b.negate()).negate()
        val minusB = b.negate()
        val positive = a > 0
        var remain = if (positive) a.negate() else a
        var base = b
        var times = 1
        var result = 0
        while (remain <= minusB) {
            val next = remain + base
            if (next > 0) {
                base = b
                times = 1
            } else {
                remain = next
                result += times
                base += base
                times += times
            }
        }
        return if (positive) result else result.negate()
    }
}