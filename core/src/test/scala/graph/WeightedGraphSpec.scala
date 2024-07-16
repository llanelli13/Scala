package graph

import org.scalatest.flatspec.AnyFlatSpec

class WeightedGraphSpec extends AnyFlatSpec {

  "A WeightedGraph" should "add and remove edges correctly" in {
    val graph = WeightedGraph.empty[Int]
      .addEdge(WeightedEdge(1, 2, 1.0))
      .addEdge(WeightedEdge(2, 3, 2.0))

    assert(graph.vertices == Set(1, 2, 3))
    assert(graph.edges == Set(WeightedEdge(1, 2, 1.0), WeightedEdge(2, 3, 2.0)))
    assert(graph.neighbors(1) == Set(2))
    assert(graph.neighbors(2) == Set(3))

    val graph2 = graph.removeEdge(WeightedEdge(1, 2, 1.0))
    assert(graph2.edges == Set(WeightedEdge(2, 3, 2.0)))
  }
}
