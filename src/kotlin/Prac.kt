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
