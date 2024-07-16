package graph

case class WeightedEdge[V](from: V, to: V, weight: Double)

class WeightedGraph[V](val vertices: Set[V], val edges: Set[WeightedEdge[V]]) extends Graph[V, WeightedEdge[V]] {
  def neighbors(vertex: V): Set[V] = edges.filter(_.from == vertex).map(_.to)

  def addEdge(edge: WeightedEdge[V]): Graph[V, WeightedEdge[V]] =
    new WeightedGraph(vertices ++ Set(edge.from, edge.to), edges + edge)

  def removeEdge(edge: WeightedEdge[V]): Graph[V, WeightedEdge[V]] =
    new WeightedGraph(vertices, edges - edge)
}

object WeightedGraph {
  def empty[V]: WeightedGraph[V] = new WeightedGraph(Set.empty, Set.empty)
}
