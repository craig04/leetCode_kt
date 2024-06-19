package cn_solution

fun defangIPaddr(address: String): String {
    return address.replace(".", "[.]")
}