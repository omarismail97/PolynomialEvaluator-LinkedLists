/*
   Data Structures Lab 3 
   @author: Omar Ismail
   4/6/21
  
*/

//Using doubly linked lists, this is how we store our polynomials
//addNode adds coef and powers into a Linked Lists
public class LinkedList {

	Node head = null;
	Node tail = null;

	LinkedList(){}


	public void addNode(int coef, int powX, int powY, int powZ) {
		if(coef == 0)
		{
			return;
		}

		// If list is empty
		if (head == null) {
			Node newNode = new Node(coef, powX, powY, powZ);
			head = tail = newNode;
			head.previous = null;
			tail.next = null;
		} else {
			Node temp = head;
			while(temp != null)
			{
				if(temp.powX == powX && temp.powY == powY && temp.powZ == powZ)
				{
					temp.coef = temp.coef+coef;
					return;
				}
				temp = temp.next;
			}
			// Create a new node
			Node newNode = new Node(coef, powX, powY, powZ);
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			tail.next = null;
		}
	}


	@Override
	public String toString()
	{
		Node current = head;
		if (head == null) {
			return "0";
		}
		String str = "";
		Boolean passed = false;
		while (current != null) {
			// Prints each node by incrementing the pointer.
			str += current.coef + "x" + current.powX + "y" + current.powY + "z" + current.powZ;
			if(current.next != null)
			{
				str += " + ";
			}
			current = current.next;
		}
		return str;
	}
}
