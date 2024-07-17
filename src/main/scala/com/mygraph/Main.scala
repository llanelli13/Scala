package com.mygraph

import zio._
import zio.Console._
import com.mygraph.GraphViz.GraphVizOps


object Main extends ZIOAppDefault {

  // Création d'un graphe orienté non pondéré
  val directedGraph = DirectedGraph(Map(
    "A" -> Set("B", "C"),
    "B" -> Set("D"),
    "C" -> Set(),
    "D" -> Set()
  ))

  // Création d'un graphe orienté pondéré
  val weightedGraph = WeightedGraph(Map(
    "A" -> Set(WeightedEdge("A", "B", 1.0), WeightedEdge("A", "C", 2.0)),
    "B" -> Set(WeightedEdge("B", "D", 3.0)),
    "C" -> Set(),
    "D" -> Set()
  ))


  override def run = {
    for {
      // Utilisation du graphe orienté non pondéré
      _ <- printLine("=== Directed Graph ===")
      _ <- printLine("Graph Vertices: " + directedGraph.vertices.mkString(", "))
      _ <- printLine("Graph Edges: " + directedGraph.edges.mkString(", "))
      _ <- printLine("DFS from A: " + dfs(directedGraph, "A").mkString(", "))
      _ <- printLine("BFS from A: " + bfs(directedGraph, "A").mkString(", "))
      _ <- printLine("GraphViz representation:\n" + directedGraph.toGraphViz)

      // Utilisation du graphe orienté pondéré
      _ <- printLine("=== Weighted Graph ===")
      _ <- printLine("Graph Vertices: " + weightedGraph.vertices.mkString(", "))
      _ <- printLine("Graph Edges: " + weightedGraph.edges.mkString(", "))
      // DFS et BFS ne sont pas utilisés sur weightedGraph car ils sont identiques à ceux pour directedGraph

      // Calcul des chemins les plus courts avec Dijkstra sur le graphe pondéré
      dijkstraResult <- ZIO.succeed(Dijkstra.shortestPath(weightedGraph, "A"))
      _ <- printLine("Dijkstra shortest paths from A:")
      _ <- ZIO.foreach(dijkstraResult.toList) { case (vertex, dist) =>
        printLine(s"$vertex -> $dist")
      }

      // Calcul des chemins les plus courts avec Floyd-Warshall
      floydWarshallResult <- ZIO.succeed(FloydWarshall.shortestPaths(weightedGraph))
      _ <- printLine("Floyd-Warshall shortest paths:")
      _ <- ZIO.foreach(floydWarshallResult.toList) { case ((source, target), distance) =>
        printLine(s"Shortest path from $source to $target: $distance")
      }

      // Affichage de la représentation GraphViz du graphe orienté pondéré
      _ <- printLine("GraphViz representation of Weighted Graph:\n" + weightedGraph.toGraphViz)
    } yield ()
  }

  // Définition des fonctions dfs et bfs (identiques à celles que vous avez déjà)
  def dfs[V](graph: DirectedGraph[V], start: V): List[V] = {
    val visited = collection.mutable.Set[V]()
    val result = collection.mutable.ListBuffer[V]()

    def dfsVisit(vertex: V): Unit = {
      visited.add(vertex)
      result += vertex
      graph.neighbors(vertex).foreach { neighbor =>
        if (!visited.contains(neighbor)) {
          dfsVisit(neighbor)
        }
      }
    }

    dfsVisit(start)
    result.toList
  }

  def bfs[V](graph: DirectedGraph[V], start: V): List[V] = {
    val visited = collection.mutable.Set[V]()
    val result = collection.mutable.ListBuffer[V]()
    val queue = collection.mutable.Queue[V]()

    visited.add(start)
    queue.enqueue(start)

    while (queue.nonEmpty) {
      val vertex = queue.dequeue()
      result += vertex
      graph.neighbors(vertex).foreach { neighbor =>
        if (!visited.contains(neighbor)) {
          visited.add(neighbor)
          queue.enqueue(neighbor)
        }
      }
    }

    result.toList
  }
}
