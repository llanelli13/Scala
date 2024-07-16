package graph

object GraphOperations {

  def dfs[V, E](graph: Graph[V, E], start: V): List[V] = {
    def dfsRecursive(vertex: V, visited: Set[V], result: List[V]): List[V] = {
      if (visited.contains(vertex)) result
      else {
        val neighbors = graph.neighbors(vertex).filterNot(visited.contains)
        neighbors.foldLeft(vertex :: result)((acc, n) => dfsRecursive(n, visited + vertex, acc))
      }
    }

    dfsRecursive(start, Set.empty, List.empty).reverse
  }
}
