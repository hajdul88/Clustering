package Graph;
import java.util.*;

public class Node {
	private String id;
	private States state;
	private ArrayList<Edge> inlist;
	private ArrayList<Edge> outlist;   
	private Set<Node> outneighbour;
	private Set<Node> neighbour;
	private int cluster;
	private int oldcluster;
	
	public Node(String id) {
		this.id = id;
		this.state = States.NOTVISITED;
		this.outlist=new ArrayList<Edge>();
		this.inlist=new ArrayList<Edge>();
		this.outneighbour=new HashSet<Node>();
		this.neighbour=new HashSet<Node>();
	}
	
	public int getAsyncNewColor(int max) {
		int[] freq = new int[max+1];
		int maxindex=0;
		int maxvalue=0;
		for(Node s: neighbour){
			freq[s.getCluster()]++;
			if(freq[s.getCluster()]>maxvalue){
				maxindex=s.getCluster();
				maxvalue=freq[s.getCluster()];
			}
		}
		return maxindex;
	}
	
	public int getSyncNewColor(int max){
		int[] freq = new int[max+1];
		int maxindex=0;
		int maxvalue=0;
		
		for(Node s: neighbour){
			freq[s.getOldcluster()]++;
			if(freq[s.getOldcluster()]>maxvalue){
				maxindex=s.getOldcluster();
				maxvalue=freq[s.getOldcluster()];
			}
		}
		return maxindex;
	}
	
	public int getOldcluster() {
		return oldcluster;
	}

	public void setOldcluster(int oldcluster) {
		this.oldcluster = oldcluster;
	}

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	public ArrayList<Edge> getInlist() {
		return inlist;
	}

	public void setInlist(ArrayList<Edge> inlist) {
		this.inlist = inlist;
	}
	
	public void addinEdge(Edge e) {
		this.inlist.add(e);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public ArrayList<Edge> getOutlist() {
		return outlist;
	}

	public void setOutlist(ArrayList<Edge> outlist) {
		this.outlist = outlist;
	}
	
	public void addOutEdge(Edge e) {
		this.outlist.add(e);
	}

	public Set<Node> getOutneighbour() {
		return outneighbour;
	}

	public void setOutneighbour(Set<Node> outneighbour) {
		this.outneighbour = outneighbour;
	}
	
	public void addOutNeighbour(Node a) {
		this.outneighbour.add(a);
	}

	public Set<Node> getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(Set<Node> neighbour) {
		this.neighbour = neighbour;
	}
	
	public void addNeighbour(Node a) {
		this.neighbour.add(a);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", state=" + state + "]";
	}
	
}
