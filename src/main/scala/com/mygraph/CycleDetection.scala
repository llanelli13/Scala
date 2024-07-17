package com.mygraph

object CycleDetection {
  def hasCycle[V](graph: DirectedGraph[V]): Boolean = {
    var visited = Set[V]()
    var stack = Set[V]()

    def dfsVisit(node: V): Boolean = {
      if (stack.contains(node)) true
      else if (visited.contains(node)) false
      else {
        visited += node
        stack += node
        val hasCycleInNeighbors = graph.neighbors(node).exists(n => dfsVisit(n))
        stack -= node
        hasCycleInNeighbors
      }
    }

    graph.vertices.exists(vertex => !visited.contains(vertex) && dfsVisit(vertex))
  }
}
