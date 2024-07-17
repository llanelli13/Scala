package com.mygraph

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DijkstraSpec extends AnyFlatSpec with Matchers {

  "Dijkstra" should "find the shortest path from the start vertex to all other vertices" in {
    val graph = WeightedGraph(Map(
      "A" -> Set(WeightedEdge("A", "B", 1), WeightedEdge("A", "C", 4)),
      "B" -> Set(WeightedEdge("B", "C", 2), WeightedEdge("B", "D", 5)),
      "C" -> Set(WeightedEdge("C", "D", 1)),
      "D" -> Set()
    ))

    val shortestPaths = Dijkstra.shortestPath(graph, "A")

    shortestPaths("D") shouldEqual 4.0
    shortestPaths("C") shouldEqual 3.0
    shortestPaths("B") shouldEqual 1.0
  }
}
