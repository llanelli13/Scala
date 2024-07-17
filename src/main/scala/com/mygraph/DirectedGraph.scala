package com.mygraph

case class DirectedGraph[V](adjList: Map[V, Set[V]]) extends Graph[V, Edge[V]] {
  def vertices: Set[V] = adjList.keySet
  def edges: Set[Edge[V]] = adjList.flatMap { case (v, neighbors) => neighbors.map(n => Edge(v, n)) }.toSet
  def neighbors(vertex: V): Set[V] = adjList.getOrElse(vertex, Set())
  def addEdge(edge: Edge[V]): DirectedGraph[V] = {
    val updatedAdjList = adjList + (edge.from -> (adjList.getOrElse(edge.from, Set()) + edge.to))
    DirectedGraph(updatedAdjList)
  }
  def removeEdge(edge: Edge[V]): DirectedGraph[V] = {
    val updatedAdjList = adjList + (edge.from -> (adjList.getOrElse(edge.from, Set()) - edge.to))
    DirectedGraph(updatedAdjList)
  }
}
