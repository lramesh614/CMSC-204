import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Comparator;

/**
 * Graph class implements GraphInterface<Town,Road>
 * @author Lokesh Sankar Ramesh
 *
 */
@SuppressWarnings("rawtypes")
public class Graph<V, R> implements GraphInterface<Town,Road> {
	
	ArrayList<Town> towns;
	
	static ArrayList<LinkedList> edges;
	Map<Town,Town> previousNode=new HashMap<>();
	
	/**
	 * default constructor to create an object of graph
	 */
	public Graph() {
		towns = new ArrayList<Town>();
		edges = new ArrayList<LinkedList>();
	}
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@SuppressWarnings("unchecked")
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
				
		int sourceIndex = 0, 
			destIndex = 0;
		boolean source = false, 
				dest = false;

		
		for(int i = 0; i < towns.size(); i++) {
			
			if(towns.get(i).compareTo(sourceVertex) == 0) {
				sourceIndex = i;
				source = true;
			}
			
			if(towns.get(i).compareTo(destinationVertex) == 0) {
				destIndex = i;
				dest = true;
			}
			
			if(source == true && dest == true) {
				break;
			}
			
		}
		
		
		Road r = new Road(sourceVertex, destinationVertex, "r");
		ListIterator<Road> itr = edges.get(sourceIndex).listIterator(0);
		
		while(itr.hasNext()) {
			Road road = itr.next();
			
			if(r.equals(road)) {
				return road;
			}
		}		
		
		return null;
	}

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@SuppressWarnings("unchecked")
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws NullPointerException, IllegalArgumentException {
		
		if(sourceVertex==null || destinationVertex==null) { 
			throw new NullPointerException();	
		}
	
		
		
		int sourceIndex=0, 
				destIndex=0;
		boolean source = false, 
				dest = false;
		
		
		
		Road edge = new Road(sourceVertex, destinationVertex,weight,description);
		
		for(int i=0; i<towns.size(); i++) {
			
			if(towns.get(i).compareTo(sourceVertex) == 0) {
				sourceIndex = i;
				source = true;
			}
			
			if(towns.get(i).compareTo(destinationVertex) == 0) {
				destIndex = i;
				dest = true;
			}
			
			if(source == true && dest == true) { break; }
			
		}
		
		if(source == false||dest == false) { 
			throw new IllegalArgumentException(); 
		} else {
			
			if(!edges.get(sourceIndex).contains(edge) && !edges.get(destIndex).contains(edge)) {
				
				edges.get(destIndex).add(edge);
				edges.get(sourceIndex).add(edge);

				sourceVertex.addAdjacentTowns(destinationVertex);
				destinationVertex.addAdjacentTowns(sourceVertex);
				
				return edge;
			}
			
		}
		
		return null;
	}

	
	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. 
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		
		for(int i=0; i < towns.size(); i++) {
			if(towns.get(i).compareTo(v) == 0) {
				return false;
			}
		}
		
		towns.add(v);
		edges.add(new LinkedList<Road>());
		
		return true;
	}

	 /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. 
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@SuppressWarnings("unchecked")
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		int sourceIndex = 0, 
				destIndex = 0;
		boolean source = false, 
				dest = false;
		
		for(int i=0; i<towns.size(); i++) {
			
			if(towns.get(i).compareTo(sourceVertex) == 0) {
				sourceIndex = i;
				source = true;
			}
			
			if(towns.get(i).compareTo(destinationVertex)==0) {
				destIndex = i;
				dest = true;
			}
			
			if(source == true && dest == true) { break; }
		}
		
		if(source == true && dest == true) {
			ListIterator<Road> itr = edges.get(sourceIndex).listIterator(0);
			while(itr.hasNext()) {
				Road r = itr.next();
				System.out.println(r.contains(sourceVertex) && r.contains(destinationVertex));

				if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
					return true;
				}
			}
	
		}
		
		return false;
	}

	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v).
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		boolean b = false;
		
		for(int i = 0; i < towns.size(); i++) {
			if(towns.get(i).compareTo(v)==0) {
				b = true;
			}
		}
		
		return b;
	}

	 /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set.
     *
     * @return a set of the edges contained in this graph.
     */
	@SuppressWarnings("unchecked")
	@Override
	public Set<Road> edgeSet() {
		Set<Road> roads = new HashSet<Road>();
		
		for(int i=0; i < edges.size(); i++) {
			ListIterator<Road> itr = edges.get(i).listIterator(0);
			
			while(itr.hasNext()) {
				Road r = itr.next();
				
				if (!roads.contains(r)) {
					roads.add(r);
				}
			}
			
		}
		
		return roads;
	}

	
	 /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@SuppressWarnings("unchecked")
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> roads = new HashSet<Road>();
		int j = 0;
		
		for(int i = 0; i < towns.size(); i++) {
			if(towns.get(i).compareTo(vertex)==0) {
				j = i;
			}
		}
		
		ListIterator<Road> itr = edges.get(j).listIterator(0);
		
		while(itr.hasNext()) {
			Road r=itr.next();
			
			if(!roads.contains(r)) {
				roads.add(r);
			}
		}
		
		return roads;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@SuppressWarnings("unchecked")
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		int sourceIndex = 0, 
				destIndex = 0;
		
		if(containsEdge(sourceVertex, destinationVertex)) {
			
			for(int i = 0;i < towns.size(); i++) {
				boolean source = false;
				
				if(towns.get(i).compareTo(sourceVertex) == 0) {
					sourceIndex = i;
					source = true;
				}
				
				boolean dest = false;
				
				if(towns.get(i).compareTo(destinationVertex) == 0) {
					destIndex = i;
					dest = true;
				}
				
				if(source == true && dest == true) { break; }
			}
			
			Road r = new Road(sourceVertex, destinationVertex, weight, description);
			
			ListIterator<Road> itr = edges.get(sourceIndex).listIterator(0);
			while(itr.hasNext()) {
				Road r2 = itr.next();
				if (r2.equals(r) && edges.get(sourceIndex).remove(r2)) { break; }
			}
			
			ListIterator<Road> itr2 = edges.get(destIndex).listIterator(0);
			while(itr2.hasNext()) {
				Road r2=itr2.next();
				if (r2.equals(r) && edges.get(sourceIndex).remove(r2)) { break; }
			}
	        
			return r;
		}
			
		return null;
	}

	
	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. 
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		
		int t = 0;
		boolean b = false;
		
		if (containsVertex(v)) {
			
			for(int i=0;i<towns.size();i++) {
				if(towns.get(i).compareTo(v) == 0) {
					t = i;
					break;
				}
			}
			
			for(int i = 0; i < v.getAdjacentTowns().size(); i++) {
				Road r = getEdge(v.getAdjacentTowns().get(i), v);
				
				if(containsEdge(v.getAdjacentTowns().get(i), v)) {
					removeEdge(v.getAdjacentTowns().get(i), v, r.getWeight(), r.getName());
				}
			}
			
			towns.remove(t);
			edges.remove(t);
			
			b = true;
		}
		
		return b;
	}

	
	 /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. 
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		Set<Town> town = new HashSet<Town>();
		
		for(int i = 0; i < towns.size(); i++) {
			
			if(!town.contains(towns.get(i))) {
				town.add(towns.get(i));
			}
		}
		
		return town;
	}

	
	 /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		ArrayList<String> path = new ArrayList<String>();
		String edge;
		
		dijkstraShortestPath(sourceVertex);
		
		Town current = destinationVertex,
				previous = previousNode.get(destinationVertex);
		 
		while(current.compareTo(sourceVertex) != 0) {
			
			edge = getEdge(current, previous).getName();
			path.add(0, previous.getName() + " via " + edge + " to " + current.getName() + " " 
			+ getEdge(current, previous).getWeight() +" mi");
			
			
			current = previous; previous = previousNode.get(current);
		}
		
		return path;
	}

	
	 /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		int distEdge, 
		distNew;
		
		Set<Town> visitedTown = new HashSet<>();
		Map<Town, Integer> weight = new HashMap<>();
		

		
		Comparator<Road> comparator = new Comparator<Road>() {	
			public int compare(Road r1, Road r2) {
				return r1.getWeight() - r2.getWeight();	
			}
		};
		
		PriorityQueue<Road> min = new PriorityQueue<>(comparator);
		
		
		min.addAll(sortEdges(sourceVertex)); 
		
		visitedTown.add(sourceVertex); 
		weight.put(sourceVertex, 0);
		
		do {
			Town t1, t2;
			Road smallRoad = min.remove();
			
			t1 = smallRoad.getSource();
			t2 = smallRoad.getDestination();
			
			
			if(!visitedTown.contains(t2)) {
				visitedTown.add(t2);
				
				for(Road r : sortEdges(t2)) {
					if(!min.contains(r)) {
						min.add(r);
					}
				}
				
				previousNode.put(t2, t1);
				
				distEdge = weight.get(t1);
				distNew = distEdge + smallRoad.getWeight();
				
				weight.put(t2, distNew);

			}
			
			if(!visitedTown.contains(t1)) {
				visitedTown.add(t1);
				for(Road r : sortEdges(t1)) {
					if(!min.contains(r)) {
						min.add(r);
					}
				}
				
				previousNode.put(t1, t2);
				
				distEdge = weight.get(t2);
				distNew = distEdge + smallRoad.getWeight();
				
				weight.put(t1, distNew);
			}
			
			if(visitedTown.contains(t1)) {
				distEdge = weight.get(t1);
				distNew = weight.get(t2) + smallRoad.getWeight();
				
				if(distNew < distEdge) {
					weight.put(t1, distNew);
					previousNode.put(t1, t2);
				}
				
			}
			
			if(visitedTown.contains(t2)) {
				
				distEdge = weight.get(t2);
				distNew = weight.get(t1) + smallRoad.getWeight();
				
				if(distNew < distEdge) {
					weight.put(t2, distNew);
					previousNode.put(t2, t1);
				}
			}
			else { continue; }
			
		} while(!min.isEmpty());
		
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Road> sortEdges(Town sourceVertex) {
		Road r = null;
		ArrayList<Road> s = new ArrayList<Road>();
		
		int j = 0;

		for(int i=0; i < towns.size(); i++) {
			if(towns.get(i).compareTo(sourceVertex) == 0) {
				j = i;
				break;
			}
		}
		
		Iterator<Road> itr = edges.get(j).iterator();
		while(itr.hasNext()) {
			if(s.size() != 0) {
				r = itr.next();
				s.add(r);			
			} else {
				s.add(itr.next());

			}
		}
		
		return s;
	}
	
	

}