import zio._
import graph._

object ZioApp extends ZIOAppDefault {

  val graphProgram: ZIO[Any, Nothing, Unit] = for {
    _ <- Console.printLine("Creating a directed graph...")
    graph = DirectedGraph.empty[Int]
      .addEdge(DirectedEdge(1, 2))
      .addEdge(DirectedEdge(2, 3))
      .addEdge(DirectedEdge(1, 3))
    _ <- Console.printLine(s"Vertices: ${graph.vertices}")
    _ <- Console.printLine(s"Edges: ${graph.edges}")
    _ <- Console.printLine(s"DFS from vertex 1: ${GraphOperations.dfs(graph, 1)}")
    _ <- Console.printLine(s"BFS from vertex 1: ${GraphOperations.bfs(graph, 1)}")
  } yield ()

  def run = graphProgram
}
