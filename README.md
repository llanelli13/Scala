Programmation fonctionnelle avec Scala
Ce projet illustre divers concepts de programmation fonctionnelle en Scala, avec un focus particulier sur les algorithmes de graphes. Il comprend notamment la recherche en profondeur (DFS), la recherche en largeur (BFS), l'algorithme de Dijkstra pour les plus courts chemins et l'algorithme de Floyd-Warshall pour les plus courts chemins entre toutes les paires. Le projet utilise des graphes dirigés et pondérés en Scala, et intègre ZIO pour la gestion des effets asynchrones.

Exigences
Java 17
Scala 3
sbt (outil de construction Scala)
Bibliothèque ZIO
Aperçu du projet
Le projet est structuré en plusieurs parties :

Graphique : Contient les implémentations de DirectedGraph et WeightedGraph en utilisant les collections Scala.
Algorithmes : Implémente DFS, BFS, l'algorithme de Dijkstra et l'algorithme de Floyd-Warshall.
Intégration ZIO : Démontre l'utilisation de ZIO pour gérer les effets asynchrones et les erreurs fonctionnelles.
GraphViz : Fournit des fonctionnalités pour générer des représentations GraphViz des graphes.
Instructions
Construire et exécuter

Cloner le dépôt :

bash
Copier le code
git clone https://github.com/llanelli13/Scala
Compiler le projet :

bash
Copier le code
sbt compile
Exécuter l'application :

bash
Copier le code
sbt run
Exemples d'utilisation

L'application principale (Main.scala) démontre diverses opérations sur les graphes, telles que :

Impression des sommets et des arêtes du graphe.
Exécution de traversées DFS et BFS à partir d'un sommet de départ.
Calcul des plus courts chemins avec l'algorithme de Dijkstra.
Calcul des plus courts chemins entre toutes les paires avec l'algorithme de Floyd-Warshall.
Génération de représentations GraphViz des graphes.
Décisions de conception
Représentation graphique : Utilisation de cartes et ensembles immuables de Scala pour représenter les graphes et leurs arêtes, garantissant la sécurité des threads et la pureté fonctionnelle.
Implémentations d'algorithmes : Chaque algorithme (DFS, BFS, Dijkstra, Floyd-Warshall) est implémenté sous forme de fonctions pures, mettant l'accent sur les principes de programmation fonctionnelle et l'immuabilité.
Gestion des erreurs : Utilisation de ZIO pour gérer les effets asynchrones et les erreurs fonctionnelles, garantissant robustesse et fiabilité dans des environnements concurrents.
Gestion de l'état : L'état du graphe est géré à l'aide de structures de données immuables, assurant la cohérence et éliminant les effets de bord.
Journalisation : Utilisation de la journalisation simple via printLine pour générer des résultats et des représentations graphiques.
Essai
Pour exécuter les tests :

bash
Copier le code
sbt test
Couverture des tests : Le projet vise une couverture de tests complète, garantissant l'exactitude des algorithmes de graphes et la gestion des effets ZIO.