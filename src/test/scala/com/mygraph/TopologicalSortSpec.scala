package com.mygraph

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TopologicalSortSpec extends AnyFlatSpec with Matchers {

  "TopologicalSort" should "sort vertices in topological order" in {
    val graph = DirectedGraph(Map("A" -> Set("C", "B"), "B" -> Set("D"), "C" -> Set("D"), "D" -> Set()))
    val sortedVertices = TopologicalSort.sort(graph)
    sortedVertices shouldEqual List("A", "B", "C", "D")
  }

}
