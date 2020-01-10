// Author: Mingyu(Miranda) Liu
// June 16, 2019
// ICS4U1-06
// Teacher: Mr. Radulovic
// Final Project

package finalProj;

public class Node {

	private Object obj;
	private Node nextNode;
	
	// The constructor sets the current element.
	public Node(Object i) {
		obj = i;
	}
	
	// Get the current element.
	public Object get() {
		return obj;
	}
	
	// Set the current element.
	public void set(Object i) {
		obj = i;
	}

	// Get the next Node.
	public Node nextNode() {
		return nextNode;
	}
	
	// Set the next Node.
	public void setNextNode(Node n) {
		nextNode = n;
	}
	
}
