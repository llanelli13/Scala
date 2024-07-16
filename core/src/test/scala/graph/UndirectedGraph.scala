package graph

import org.scalatest.flatspec.AnyFlatSpec

class UndirectedGraphSpec extends AnyFlatSpec {

  "An UndirectedGraph" should "add and remove edges correctly" in {
    val graph = UndirectedGraph.empty[Int]
      .addEdge(UndirectedEdge(1, 2))
      .addEdge(UndirectedEdge(2, 3))

    assert(graph.vertices == Set(1, 2, 3))
    assert(graph.edges == Set(UndirectedEdge(1, 2), UndirectedEdge(2, 3)))
    assert(graph.neighbors(1) == Set(2))
    assert(graph.neighbors(2) == Set(1, 3))

    val graph2 = graph.removeEdge(UndirectedEdge(1, 2))
    assert(graph2.edges == Set(UndirectedEdge(2, 3)))
  }
}
