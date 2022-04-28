import java.util.ArrayList;

/**
 * Town(vertex) class
 *
 *@author Lokesh Sankar Ramesh
 */
public class Town implements Comparable <Town> {

	private String name;
	private ArrayList<Town> townsAdjacent;
	
	
	/**
	 * constructor instantiates name of town
	 * @param name name to assign to field name
	 */
	public Town(String n) {
		name = n;
		townsAdjacent = new ArrayList<Town>();
		
	}
	
	/**
	 * @return name of town
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return reference to list of adjacent towns of a town
	 */
	public ArrayList<Town> getAdjacentTowns(){
		return townsAdjacent;
	}
	
	/**
	 * @return hashCode of name of town
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * sets name of town
	 * @param name name of town
	 */
	public void setName(String n) {
		name = n;
	}
	

	/**
	 * sets the list of adjacent towns 
	 * @param towns arrayList of adjacent towns
	 */
	public void setAdjacentTowns(ArrayList<Town> towns) {
		
		for(int i=0;i<towns.size();i++) {
			townsAdjacent.add(towns.get(i));
		}
	}
	
	/**
	 * adds a town in the list of adjacent towns
	 * @param town town to be added to the list
	 */
	public void addAdjacentTowns(Town town) {
		townsAdjacent.add(town);
	}
	
	
	/**
	 * compares 2 towns. returns 0 if they have the same name, a negative number or positive number if they are not equal
	 */
	@Override
	public int compareTo(Town t) {
		if(t.getName().equalsIgnoreCase(name)) {
			return 0;
		} else {
			return name.compareToIgnoreCase(t.getName());
		}
	}
	
	
	/**
	 * @return information on a town in a string format
	 */
	public String toString() {
		String t = "";
		
		for(int i=0;i<townsAdjacent.size();i++) {
			t += townsAdjacent.get(i).getName() + " ";
		}
		
		return "Name of Town: " + name + "\t Adjacent Towns: " + t + "\n";
	}

}