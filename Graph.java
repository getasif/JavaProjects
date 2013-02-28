import java.util.*;
/**
 * Implements a Graph data structure with basic graph functionality. The
 * underlying implementation and representation is of an adjacency list.
 *
 * @author Akshay Hegde CS146
 */
public class Graph
{

   /**
    * Constructs a Graph with a set number of vertices
    *
    * @param vertices the number of vertices in the Graph. The number can be
    *                 from 0 to n - 1.
    */
   public Graph(int vertices)
   {
      numOfVertices = vertices;
      numOfEdges = 0;
      adjacencyList = new ArrayList < TreeMap < Integer, Integer > > ();
      incomingList = new ArrayList < TreeMap < Integer, Integer > > ();

      for (int i = 0; i < numOfVertices; i++)
      {
         adjacencyList.add(i, new TreeMap < Integer, Integer > ());
         incomingList.add(i, new TreeMap < Integer, Integer > ());
      }
   }

   /**
    * Adds an edge from the given source node to the destination node, of the
    * given weight.
    *
    * @param source      source the source node
    * @param destination destination the destination node
    * @param weight      weight the weight of the edge that exists between the
    *                    source and the destination node
    * @return true if an edge can be added from the source to the destination
    *         without one vertex having multiple edges, false otherwise.
    */
   public boolean addEdge(int source, int destination, int weight)
   {
      if (!adjacencyList.get(source).containsKey(destination))
      {
         adjacencyList.get(source).put(destination, weight);
         incomingList.get(destination).put(source, weight);
         numOfEdges++;
         return true;
      }
      return false;
   }

   /**
    * Gets the list of outgoing edges of a vertex. Each line of output has an
    * even number of integer values to be considered in pairs. The first value
    * is the index of a vertex that the edges goes to, the second value is the
    * weight of that edge and the ith string represents the outgoing edges of
    * vertex i in the graph.
    *
    * @return the ArrayList<String> representation of the outgoing edges of a
    *         vertex.
    */
   public ArrayList < String > getOutgoingGraphRepresentation()
   {
      ArrayList < String > outgoing = new ArrayList < String > ();
      int length = this.adjacencyList.size();
      String tempString;
      for (int i = 0; i < length; i++)
      {
         tempString = adjacencyList.get(i).toString().replaceAll(
                 "=", " ").replaceAll("}", "").replaceAll(
                 "\\{", "").replaceAll(",", "");
         outgoing.add(tempString);
      }

      return outgoing;
   }

   /**
    * Gets the list of incoming edges of a vertex. Each line of output has an
    * even number of integer values to be considered in pairs. The first value
    * is the index of a vertex that the edges comes from, the second value is
    * the weight of that edge and the ith string represents the incoming edges
    * of vertex i in the graph.
    *
    * @return the ArrayList<String> representation of the incoming edges of a
    *         vertex.
    */
   public ArrayList < String > getIncomingGraphRepresentation()
   {
      ArrayList < String > incoming = new ArrayList < String > ();
      int length = this.incomingList.size();
      String tempString;
      for (int i = 0; i < length; i++)
      {
         tempString = incomingList.get(i).toString().replaceAll(
                 "=" , " ").replaceAll("}" , "").replaceAll(
                 "\\{" , "").replaceAll("," , "");
         incoming.add(tempString);
      }

      return incoming;
   }

   /**
    * Checks if the source node has an edge to the destination node.
    * @param source      the source node
    * @param destination the destination node
    * @return true if the source has an edge to the destination, false
    *         otherwise.
    */
   public boolean hasEdge(int source, int destination)
   {
      return adjacencyList.get(source).containsKey(destination);
   }

   /**
    * Gets the weight of the edge that exists between the source and the
    * destination node.
    *
    * @param source      the source node
    * @param destination the destination node
    * @return the edge weight between the source and the destination node
    */
   public int getEdgeWeight(int source, int destination)
   {
      return adjacencyList.get(source).get(destination);
   }

   /**
    * Gets the in-degree of the given vertex, which represents the number of
    * edges that go to the given vertex.
    *
    * @param vertexIndex the index of the vertex to check the in-degree of
    * @return the in-degree of the vertexIndex
    */
   public int inDegree(int vertexIndex)
   {
      return incomingList.get(vertexIndex).size();
   }

   /**
    * Gets the out-degree of the given vertex, which represents the number of
    * edges that goes out from the given vertex
    *
    * @param vertexIndex the index of the vertex to check the in-degree of
    * @return the out-degree of the vertexIndex
    */
   public int outDegree(int vertexIndex)
   {
      return adjacencyList.get(vertexIndex).size();
   }

   /**
    * Gets the number of vertices in the Graph
    * @return the number of vertices in the graph
    */
   public int getNumOfVertices()
   {
      return numOfVertices;
   }

   /**
    * Gets the number of edges in the Graph
    * @return the number of edges
    */
   public int getNumOfEdges()
   {
      return numOfEdges;
   }

   // The total number of vertices in the Graph
   private final int numOfVertices;

   // The number of edges in the Graph
   private int numOfEdges;

   // An ArrayList of HashMaps that represent an adjacency list
   private ArrayList < TreeMap < Integer, Integer > > adjacencyList;

   // Incoming list
   private ArrayList < TreeMap < Integer, Integer > > incomingList;
}
