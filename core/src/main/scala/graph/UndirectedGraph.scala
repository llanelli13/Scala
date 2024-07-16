package graph

case class UndirectedEdge[V](v1: V, v2: V)

class UndirectedGraph[V](val vertices: Set[V], val edges: Set[UndirectedEdge[V]]) extends Graph[V, UndirectedEdge[V]] {
  def neighbors(vertex: V): Set[V] = edges.collect {
    case UndirectedEdge(`vertex`, v) => v
    case UndirectedEdge(v, `vertex`) => v
  }

  def addEdge(edge: UndirectedEdge[V]): Graph[V, UndirectedEdge[V]] =
    new UndirectedGraph(vertices ++ Set(edge.v1, edge.v2), edges + edge)

  def removeEdge(edge: UndirectedEdge[V]): Graph[V, UndirectedEdge[V]] =
    new UndirectedGraph(vertices, edges - edge)
}

object UndirectedGraph {
  def empty[V]: UndirectedGraph[V] = new UndirectedGraph(Set.empty, Set.empty)
}
