package com.mygraph

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GraphSpec extends AnyFlatSpec with Matchers {

  "A DirectedGraph" should "add edges correctly" in {
    // Initial graph with one edge
    val graph = DirectedGraph(Map("A" -> Set("B")))

    // Adding a new edge
    val updatedGraph = graph.addEdge(Edge("A", "C"))

    // Assert that the updated graph contains the new edge
    updatedGraph.edges should contain(Edge("A", "C"))
  }
}
