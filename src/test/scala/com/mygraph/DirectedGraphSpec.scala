package com.mygraph

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DirectedGraphSpec extends AnyFlatSpec with Matchers {

  "A DirectedGraph" should "add edges correctly" in {
    val graph = DirectedGraph(Map("A" -> Set("B")))
    val updatedGraph = graph.addEdge(Edge("A", "C"))
    updatedGraph.edges should contain(Edge("A", "C"))
  }

  it should "return vertices correctly" in {
    val graph = DirectedGraph(Map("A" -> Set("B", "C"), "B" -> Set("D"), "C" -> Set(), "D" -> Set()))
    graph.vertices shouldEqual Set("A", "B", "C", "D")
  }
}
