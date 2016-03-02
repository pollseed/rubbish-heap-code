import java.lang.StringBuilder

fun toJSON(collection: Collection<Int>): String {
    val sb = StringBuilder("[")
    var i = 0
    for (c in collection) {
        if (i != 0) sb.append(", ")
        sb.append(c)
        i++
    }
    sb.append("]")
    return sb.toString()
}
