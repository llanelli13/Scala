package graph

import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

object GraphOperations {

  def dijkstra[V](graph: WeightedGraph[V], start: V): Map[V, Double] = {
    val distances = mutable.Map[V, Double](start -> 0.0).withDefaultValue(Double.PositiveInfinity)
    val pq = PriorityQueue((start, 0.0))(Ordering.by(-_._2))
    val visited = mutable.Set[V]()

    while (pq.nonEmpty) {
      val (current, currentDist) = pq.dequeue()
      if (!visited.contains(current)) {
        visited += current
        for (edge <- graph.edges if edge.from == current) {
          val newDist = currentDist + edge.weight
          if (newDist < distances(edge.to)) {
            distances(edge.to) = newDist
            pq.enqueue((edge.to, newDist))
          }
        }
      }
    }
    distances.toMap
  }
}
