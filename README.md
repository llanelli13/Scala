# Functional Programming with Scala

This project demonstrates various functional programming concepts implemented in Scala, focusing on graph algorithms such as Depth-First Search (DFS), Breadth-First Search (BFS), Dijkstra's algorithm for shortest paths, and Floyd-Warshall algorithm for all pairs shortest paths. It includes implementations of directed and weighted graphs using Scala and ZIO for asynchronous effect management.

## Requirements

- Java 17
- Scala 3
- sbt (Scala Build Tool)
- ZIO library

## Project Overview

The project consists of several components:

- **Graph**: Contains implementations of DirectedGraph and WeightedGraph using Scala collections.
- **Algorithms**: Implements DFS, BFS, Dijkstra's algorithm, and Floyd-Warshall algorithm.
- **ZIO Integration**: Demonstrates usage of ZIO for managing asynchronous effects and functional error handling.
- **GraphViz**: Provides functionality to generate GraphViz representations of graphs.

## Instructions

### Build and Run

1. **Clone the repository:**

git clone https://github.com/CloNTCL/FunctionalProg


2. **Compile the project:**

sbt compile


3. **Run the application:**

sbt run


### Usage Examples

The main application (`Main.scala`) demonstrates various operations on graphs:

- Printing graph vertices and edges.
- Performing DFS and BFS traversal from a starting vertex.
- Computing shortest paths using Dijkstra's algorithm.
- Computing all pairs shortest paths using Floyd-Warshall algorithm.
- Generating GraphViz representations of graphs.

### Design Decisions

- **Graph Representation**: Used Scala's immutable maps and sets for representing graphs and their edges, ensuring thread safety and functional purity.

- **Algorithm Implementations**: Each algorithm (DFS, BFS, Dijkstra, Floyd-Warshall) is implemented as pure functions, emphasizing functional programming principles and immutability.

- **Error Handling**: ZIO is used for managing asynchronous effects and functional error handling, ensuring robustness in concurrent environments.

- **State Management**: Graph state is managed using immutable data structures, maintaining consistency and eliminating side effects.

- **Logging**: Simple console logging (`printLine`) is used for outputting results and graph representations.

### Testing

1. **Run tests:**

sbt test

2. **Test Coverage:**
The project aims for comprehensive test coverage, ensuring correctness of graph algorithms and ZIO effects handling.