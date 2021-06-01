/*
   Data Structures Lab 3 
   @author: Omar Ismail
   4/6/21
  
*/

//Intializing my Node (allowing for coefficients and powers of variables)
class Node {
	int coef;
	int powX, powY, powZ;
	Node next;
	Node previous;

	Node(int coef, int powX, int powY, int powZ) {
		this.coef = coef;
		this.powX = powX;
		this.powY = powY;
		this.powZ = powZ;
		next = null;
	}
}
