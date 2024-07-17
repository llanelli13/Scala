package com.mygraph

object FloydWarshall {
  def shortestPaths[V](graph: WeightedGraph[V]): Map[(V, V), Double] = {
    val vertices = graph.vertices.toList
    val dist = collection.mutable.Map[(V, V), Double]()

    for {
      u <- vertices
      v <- vertices
    } dist((u, v)) = if (u == v) 0 else Double.PositiveInfinity

    for {
      u <- vertices
      edge <- graph.neighbors(u)
    } dist((u, edge.to)) = edge.weight

    for {
      k <- vertices
      i <- vertices
      j <- vertices
    } {
      val newDist = dist((i, k)) + dist((k, j))
      if (newDist < dist((i, j))) dist((i, j)) = newDist
    }

    dist.toMap
  }
}
