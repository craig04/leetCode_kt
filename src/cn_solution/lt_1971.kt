package cn_solution

import base.UnionFind

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val uf = UnionFind(n)
    for ((u, v) in edges)
        uf.union(u, v)
    return uf.find(source) == uf.find(destination)
}