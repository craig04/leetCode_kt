package cn_solution

import java.util.*

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    class Food(
        val name: String,
        var cuisine: String,
        var rating: Int
    ) : Comparable<Food> {
        override fun compareTo(other: Food): Int {
            return if (rating == other.rating) name.compareTo(other.name) else other.rating - rating
        }
    }

    val g = HashMap<String, TreeSet<Food>>()
    val h = HashMap<String, Food>()

    init {
        for (i in foods.indices) {
            val food = Food(foods[i], cuisines[i], ratings[i])
            g.getOrPut(food.cuisine) { TreeSet() }.add(food)
            h[food.name] = food
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val f = h[food] ?: return
        g[f.cuisine]?.remove(f)
        f.rating = newRating
        g[f.cuisine]?.add(f)
    }

    fun highestRated(cuisine: String): String {
        return g[cuisine]?.firstOrNull()?.name ?: ""
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * var obj = FoodRatings(foods, cuisines, ratings)
 * obj.changeRating(food,newRating)
 * var param_2 = obj.highestRated(cuisine)
 */