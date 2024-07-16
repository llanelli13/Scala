package graph

case class DirectedEdge[V](from: V, to: V)

class DirectedGraph[V](val vertices: Set[V], val edges: Set[DirectedEdge[V]]) extends Graph[V, DirectedEdge[V]] {
  def neighbors(vertex: V): Set[V] = edges.filter(_.from == vertex).map(_.to)

  def addEdge(edge: DirectedEdge[V]): Graph[V, DirectedEdge[V]] =
    new DirectedGraph(vertices ++ Set(edge.from, edge.to), edges + edge)

  def removeEdge(edge: DirectedEdge[V]): Graph[V, DirectedEdge[V]] =
    new DirectedGraph(vertices, edges - edge)
}

object DirectedGraph {
  def empty[V]: DirectedGraph[V] = new DirectedGraph(Set.empty, Set.empty)
}
