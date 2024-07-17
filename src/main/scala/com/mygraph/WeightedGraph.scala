package com.mygraph

case class WeightedEdge[V](from: V, to: V, weight: Double)

case class WeightedGraph[V](adjList: Map[V, Set[WeightedEdge[V]]]) {
  def vertices: Set[V] = adjList.keySet
  def edges: Set[WeightedEdge[V]] = adjList.values.flatten.toSet
  def neighbors(vertex: V): Set[WeightedEdge[V]] = adjList.getOrElse(vertex, Set())
  def addEdge(edge: WeightedEdge[V]): WeightedGraph[V] = {
    val updatedAdjList = adjList + (edge.from -> (adjList.getOrElse(edge.from, Set()) + edge))
    WeightedGraph(updatedAdjList)
  }
  def removeEdge(edge: WeightedEdge[V]): WeightedGraph[V] = {
    val updatedAdjList = adjList + (edge.from -> (adjList.getOrElse(edge.from, Set()) - edge))
    WeightedGraph(updatedAdjList)
  }

  def toGraphViz: String = {
    val verticesStr = vertices.map(v => s""""$v"""").mkString(" ")
    val edgesStr = edges.map {
      case WeightedEdge(from, to, weight) => s""""$from" -> "$to" [label="$weight"]"""
    }.mkString("\n")
    s"digraph WeightedGraph {\n$verticesStr\n$edgesStr\n}"
  }
}
