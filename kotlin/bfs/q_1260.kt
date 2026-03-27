package bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


lateinit var visited: BooleanArray
lateinit var A: Array<MutableList<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val start = st.nextToken().toInt()

    A = Array(N + 1) { mutableListOf() }

    repeat(M) {
        val st2 = StringTokenizer(br.readLine())
        val S = st2.nextToken().toInt()
        val E = st2.nextToken().toInt()
        A[S].add(E)
        A[E].add(S)
    }

    for (i in 1..N) {
        A[i].sort()
    }

    visited = BooleanArray(N + 1)
    dfs(start)
    println()

    visited = BooleanArray(N + 1)
    bfs(start)
    println()
}

fun dfs(node: Int) {
    print("$node ")
    visited[node] = true

    for (i in A[node]) {
        if (!visited[i]) {
            dfs(i)
        }
    }
}

fun bfs(node: Int) {
    val queue = ArrayDeque<Int>()
    queue.add(node)
    visited[node] = true

    while (queue.isNotEmpty()) {
        val now = queue.removeFirst()
        print("$now ")

        for (i in A[now]) {
            if (!visited[i]) {
                visited[i] = true
                queue.addLast(i)
            }
        }
    }
}