package com.mygraph

trait Graph[V, E] {
  def vertices: Set[V]
  def edges: Set[E]
  def neighbors(vertex: V): Set[V]
  def addEdge(edge: E): Graph[V, E]
  def removeEdge(edge: E): Graph[V, E]
}

case class Edge[V](from: V, to: V)
