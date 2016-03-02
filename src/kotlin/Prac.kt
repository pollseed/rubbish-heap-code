import java.lang.StringBuilder

fun joinOptions(options: Collection<String>): String {
    val sb: StringBuilder = StringBuilder("[")
    var i: Int = 0
    for (c: String in options) {
        if (i != 0) sb.append(", ")
        sb.append(c)
        i++
    }
    sb.append("]")
    return sb.toString()
}

fun foo(name: String, number: Int, toUpperCase: Boolean) =
        (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
        foo("a", 42, false),
        foo("b", 1, false),
        foo("c", 42, toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
)
