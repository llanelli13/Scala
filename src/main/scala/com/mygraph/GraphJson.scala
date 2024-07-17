package com.mygraph

import zio.json._

object GraphJson {

  case class Node(id: String)
  object Node {
    implicit val decoder: JsonDecoder[Node] = DeriveJsonDecoder.gen[Node]
    implicit val encoder: JsonEncoder[Node] = DeriveJsonEncoder.gen[Node]
  }

  case class Edge(source: String, target: String)
  object Edge {
    implicit val decoder: JsonDecoder[Edge] = DeriveJsonDecoder.gen[Edge]
    implicit val encoder: JsonEncoder[Edge] = DeriveJsonEncoder.gen[Edge]
  }

  case class WeightedEdge(source: String, target: String, weight: Double)
  object WeightedEdge {
    implicit val decoder: JsonDecoder[WeightedEdge] = DeriveJsonDecoder.gen[WeightedEdge]
    implicit val encoder: JsonEncoder[WeightedEdge] = DeriveJsonEncoder.gen[WeightedEdge]
  }

  case class DirectedGraph(vertices: Map[String, Set[String]]) {
    def toGraphViz: String = {
      vertices.map { case (src, targets) =>
        targets.map(tgt => s"$src -> $tgt;").mkString("\n")
      }.mkString("\n")
    }

    def neighbors(vertex: String): Set[String] = vertices.getOrElse(vertex, Set())
  }
  object DirectedGraph {
    implicit val decoder: JsonDecoder[DirectedGraph] = DeriveJsonDecoder.gen[DirectedGraph]
    implicit val encoder: JsonEncoder[DirectedGraph] = DeriveJsonEncoder.gen[DirectedGraph]
  }

  case class WeightedGraph(vertices: Map[String, Set[WeightedEdge]]) {
    def toGraphViz: String = {
      vertices.map { case (src, edges) =>
        edges.map(e => s"$src -> ${e.target} [label=${e.weight}];").mkString("\n")
      }.mkString("\n")
    }
  }
  object WeightedGraph {
    implicit val decoder: JsonDecoder[WeightedGraph] = DeriveJsonDecoder.gen[WeightedGraph]
    implicit val encoder: JsonEncoder[WeightedGraph] = DeriveJsonEncoder.gen[WeightedGraph]
  }
}
