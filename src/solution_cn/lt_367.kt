package solution_cn

import java.lang.Math.floor
import java.lang.Math.sqrt

fun isPerfectSquare(num: Int): Boolean {
    return floor(sqrt(num.toDouble())).toInt().run { times(this) } == num
}