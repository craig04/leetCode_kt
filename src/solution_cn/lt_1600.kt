package solution_cn

class ThroneInheritance(kingName: String) {

    class Person(val name: String) {
        var dead = false
        val children = ArrayList<Person>()
    }

    private val king = Person(kingName)
    private val map = hashMapOf(kingName to king)

    fun birth(parentName: String, childName: String) {
        val person = Person(childName)
        map[childName] = person
        map[parentName]?.children?.add(person)
    }

    fun death(name: String) {
        map[name]?.dead = true
    }

    fun getInheritanceOrder(): List<String> {
        val result = ArrayList<String>()
        fun build(person: Person) {
            if (!person.dead) {
                result.add(person.name)
            }
            person.children.forEach { build(it) }
        }
        build(king)
        return result
    }
}