package graph

import org.scalatest.flatspec.AnyFlatSpec

class DirectedGraphSpec extends AnyFlatSpec {

  "A DirectedGraph" should "add and remove edges correctly" in {
    val graph = DirectedGraph.empty[Int]
      .addEdge(DirectedEdge(1, 2))
      .addEdge(DirectedEdge(2, 3))

    assert(graph.vertices == Set(1, 2, 3))
    assert(graph.edges == Set(DirectedEdge(1, 2), DirectedEdge(2, 3)))
    assert(graph.neighbors(1) == Set(2))
    assert(graph.neighbors(2) == Set(3))

    val graph2 = graph.removeEdge(DirectedEdge(1, 2))
    assert(graph2.edges == Set(DirectedEdge(2, 3)))
  }
}
