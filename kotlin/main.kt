import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val prefix = IntArray(n + 1)
    st = StringTokenizer(br.readLine())

    for (i in 1..n) {
        prefix[i] = prefix[i - 1] + st.nextToken().toInt()
    }

    val sb = StringBuilder()

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        sb.append(prefix[end] - prefix[start - 1]).append('\n')
    }

    print(sb)
}