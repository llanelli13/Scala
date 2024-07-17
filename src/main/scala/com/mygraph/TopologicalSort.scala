package com.mygraph

object TopologicalSort {

  def sort[V](graph: DirectedGraph[V]): List[V] = {
    val visited = collection.mutable.Set[V]()
    val result = collection.mutable.ListBuffer[V]()

    // DFS function to explore the graph
    def dfs(vertex: V): Unit = {
      visited.add(vertex)
      // Explore neighbors
      graph.neighbors(vertex).foreach { neighbor =>
        if (!visited.contains(neighbor)) {
          dfs(neighbor)
        }
      }
      // Add vertex to the result in reverse order
      result.prepend(vertex)
    }

    // Perform DFS for all vertices
    graph.vertices.foreach { vertex =>
      if (!visited.contains(vertex)) {
        dfs(vertex)
      }
    }

    result.toList
  }
}
