/**
 * Road(edge) class
 * 
 * @author Lokesh Sankar Ramesh
 *
 */
public class Road implements Comparable<Road> {
	
	private Town t1, 
	t2;
	private int weight;
	private String name;
	
	
	/**
	 * constructor with weight preset to 1
	 * @param source first town
	 * @param destination second town
	 * @param name name of road
	 */
	public Road(Town source, Town destination, String name) {
		this(source, destination, 1, name);
		
	}
	
	/**
	 * constructor to create a new road(edge)
	 * @param source first town
	 * @param destination second town
	 * @param weight distance from one town to the other
	 * @param name name of road
	 */
	public Road(Town source, Town destination, int weight, String name) {
		t1 = source;
		t2 = destination;
		this.weight = weight;
		this.name = name;
	}
	
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town vertex of the graph
	 * @return true only if the edge contains the given vertex
	 */
	public boolean contains(Town town) {
		return ((town.getName().equalsIgnoreCase(t1.getName()))|| (town.getName().equalsIgnoreCase(t2.getName())));
	}
	/**
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	@Override
	public int compareTo(Road r) {
		return name.compareToIgnoreCase(r.getName());
	}
	
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. 
	 * Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
	 * @param r road object to compare it to
	 * @return true if each of the ends of the road r is the same as the ends of this road
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Road)) {
			return false;
		} else {
			String r1 = ((Road) o).getSource().getName();
			String r2 = ((Road) o).getDestination().getName();
			
			return (t1.getName().equalsIgnoreCase(r1) || t1.getName().equalsIgnoreCase(r2)) && (t2.getName().equalsIgnoreCase(r1) || t2.getName().equalsIgnoreCase(r2));
		}
	}
	
	
	
	
	/**
	 * returns first town on the road
	 * @return first town
	 */
	public Town getSource() {
		return t1;
	}
	
	/**
	 * returns second town
	 * @return second Town
	 */
	public Town getDestination() {
		return t2;
	}
	
	/**
	 * returns the weight(distance) of road
	 * @return weight 
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * returns name of road
	 * @return name of road
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @return string format of road information
	 */
	@Override
	public String toString() {
		return name + " connects " + t1.getName() + " and " + t2.getName()+" and is " + weight + " miles long";
		
	}

}