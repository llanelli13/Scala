package com.mygraph

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CycleDetectionSpec extends AnyFlatSpec with Matchers {

  "CycleDetection" should "detect a cycle in a directed graph" in {
    // Create a directed graph with a cycle
    val graphWithCycle = DirectedGraph(Map("A" -> Set("B"), "B" -> Set("C"), "C" -> Set("A")))
    val hasCycle = CycleDetection.hasCycle(graphWithCycle)
    hasCycle shouldEqual true
  }

  it should "not detect a cycle in a directed acyclic graph (DAG)" in {
    // Create a directed acyclic graph (DAG)
    val dag = DirectedGraph(Map("A" -> Set("B", "C"), "B" -> Set("D"), "C" -> Set("D"), "D" -> Set()))
    val hasCycle = CycleDetection.hasCycle(dag)
    hasCycle shouldEqual false
  }
}
