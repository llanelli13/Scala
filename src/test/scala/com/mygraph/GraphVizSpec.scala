package com.mygraph

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

// Importez la méthode d'extension ici si elle est définie dans GraphViz
import com.mygraph.GraphViz.GraphVizOps

class GraphVizSpec extends AnyFlatSpec with Matchers {
  "A DirectedGraph" should "generate correct GraphViz representation" in {
    val graph = DirectedGraph(Map("A" -> Set("B", "C"), "B" -> Set("D"), "C" -> Set("D"), "D" -> Set()))

    // Utilisez la méthode d'extension pour convertir le graphe en GraphViz
    val graphViz = graph.toGraphViz

    val expectedGraphViz = """digraph G {
                             |  "A" -> "B";
                             |  "A" -> "C";
                             |  "B" -> "D";
                             |  "C" -> "D";
                             |}""".stripMargin

    // Utilisez trim pour ignorer les différences de formatage
    graphViz.trim shouldEqual expectedGraphViz.trim
  }
}
