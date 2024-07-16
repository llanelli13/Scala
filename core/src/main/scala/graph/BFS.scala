package graph

import scala.collection.mutable

object GraphOperations {

  def bfs[V, E](graph: Graph[V, E], start: V): List[V] = {
    val visited = mutable.Set[V]()
    val queue = mutable.Queue[V](start)
    var result = List[V]()

    while (queue.nonEmpty) {
      val vertex = queue.dequeue()
      if (!visited.contains(vertex)) {
        visited += vertex
        result = result :+ vertex
        queue ++= graph.neighbors(vertex).filterNot(visited.contains)
      }
    }
    result
  }
}
