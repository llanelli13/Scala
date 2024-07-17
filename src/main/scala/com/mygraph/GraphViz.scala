package com.mygraph

object GraphViz {
  implicit class GraphVizOps[V](graph: DirectedGraph[V]) {
    def toGraphViz: String = {
      val sb = new StringBuilder
      sb.append("digraph G {\n")
      for {
        (vertex, neighbors) <- graph.adjList
        neighbor <- neighbors
      } sb.append(s"""  "$vertex" -> "$neighbor";\n""")
      sb.append("}\n")
      sb.toString()
    }
  }
}
