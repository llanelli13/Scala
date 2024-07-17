package com.mygraph

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import zio.json._

class GraphJsonSpec extends AnyFlatSpec with Matchers {
  import GraphJson._

  "Node" should "be correctly encoded to and decoded from JSON" in {
    val node = Node("1")
    val json = node.toJson
    json shouldEqual """{"id":"1"}"""

    val decodedNode = json.fromJson[Node]
    decodedNode shouldEqual Right(node)
  }

  "Edge" should "be correctly encoded to and decoded from JSON" in {
    val edge = Edge("1", "2")
    val json = edge.toJson
    json shouldEqual """{"source":"1","target":"2"}"""

    val decodedEdge = json.fromJson[Edge]
    decodedEdge shouldEqual Right(edge)
  }

  "WeightedEdge" should "be correctly encoded to and decoded from JSON" in {
    val weightedEdge = WeightedEdge("1", "2", 1.0)
    val json = weightedEdge.toJson
    json shouldEqual """{"source":"1","target":"2","weight":1.0}"""

    val decodedWeightedEdge = json.fromJson[WeightedEdge]
    decodedWeightedEdge shouldEqual Right(weightedEdge)
  }

  "DirectedGraph" should "be correctly encoded to and decoded from JSON" in {
    val directedGraph = DirectedGraph(Map("A" -> Set("B", "C"), "B" -> Set("D"), "C" -> Set(), "D" -> Set()))
    val json = directedGraph.toJson
    json shouldEqual """{"vertices":{"A":["B","C"],"B":["D"],"C":[],"D":[]}}"""

    val decodedDirectedGraph = json.fromJson[DirectedGraph]
    decodedDirectedGraph shouldEqual Right(directedGraph)
  }

  "WeightedGraph" should "be correctly encoded to and decoded from JSON" in {
    val weightedGraph = WeightedGraph(Map("A" -> Set(WeightedEdge("A", "B", 1.0), WeightedEdge("A", "C", 2.0)), "B" -> Set(WeightedEdge("B", "D", 3.0)), "C" -> Set(), "D" -> Set()))
    val json = weightedGraph.toJson
    json shouldEqual """{"vertices":{"A":[{"source":"A","target":"B","weight":1.0},{"source":"A","target":"C","weight":2.0}],"B":[{"source":"B","target":"D","weight":3.0}],"C":[],"D":[]}}"""

    val decodedWeightedGraph = json.fromJson[WeightedGraph]
    decodedWeightedGraph shouldEqual Right(weightedGraph)
  }
}
