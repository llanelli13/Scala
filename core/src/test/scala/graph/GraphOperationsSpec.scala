package graph

import org.scalatest.flatspec.AnyFlatSpec

class GraphOperationsSpec extends AnyFlatSpec {

  "DFS" should "traverse the graph in depth-first order" in {
    val graph = DirectedGraph.empty[Int]
      .addEdge(DirectedEdge(1, 2))
      .addEdge(DirectedEdge(2, 3))
      .addEdge(DirectedEdge(1, 3))

    assert(GraphOperations.dfs(graph, 1) == List(1, 2, 3))
  }

  "BFS" should "traverse the graph in breadth-first order" in {
    val graph = DirectedGraph.empty[Int]
      .addEdge(DirectedEdge(1, 2))
      .addEdge(DirectedEdge(2, 3))
      .addEdge(DirectedEdge(1, 3))

    assert(GraphOperations.bfs(graph, 1) == List(1, 2, 3))
  }

  "Dijkstra" should "find the shortest path in a weighted graph" in {
    val graph = WeightedGraph.empty[Int]
      .addEdge(WeightedEdge(1, 2, 1.0))
      .addEdge(WeightedEdge(2, 3, 2.0))
      .addEdge(WeightedEdge(1, 3, 4.0))

    val distances = GraphOperations.dijkstra(graph, 1)
    assert(distances(1) == 0.0)
    assert(distances(2) == 1.0)
    assert(distances(3) == 3.0)
  }
}
