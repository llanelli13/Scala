package com.mygraph

import scala.collection.mutable

object Dijkstra {
  def shortestPath[V](graph: WeightedGraph[V], start: V): Map[V, Double] = {
    val distances = mutable.Map[V, Double](start -> 0)
    val priorityQueue = mutable.PriorityQueue[(Double, V)]((0, start))(Ordering.by(-_._1))
    val visited = mutable.Set[V]()

    while (priorityQueue.nonEmpty) {
      val (currentDist, currentVertex) = priorityQueue.dequeue()

      if (!visited.contains(currentVertex)) {
        visited.add(currentVertex)

        for (edge <- graph.neighbors(currentVertex)) {
          val newDist = currentDist + edge.weight
          if (newDist < distances.getOrElse(edge.to, Double.PositiveInfinity)) {
            distances(edge.to) = newDist
            priorityQueue.enqueue((newDist, edge.to))
          }
        }
      }
    }

    distances.toMap
  }
}
