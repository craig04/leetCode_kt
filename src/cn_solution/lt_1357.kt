package cn_solution

class Cashier(val n: Int, val discount: Int, val products: IntArray, val prices: IntArray) {

    var idx = 0

    fun getBill(product: IntArray, amount: IntArray): Double {
        idx = (idx + 1) % n
        val ratio = if (idx == 0) 1 - discount / 100.0 else 1.0
        return product.indices.sumOf { prices[products.indexOf(product[it])] * amount[it] * ratio }
    }
}