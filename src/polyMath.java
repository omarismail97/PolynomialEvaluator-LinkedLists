/*
   Data Structures Lab 3 
   @author: Omar Ismail
   4/6/21
  
*/
public class polyMath {
    /* 
      -all arithemtic is happening here 
      -Adding,subtracting,multiplying, and eval
      -It also includes a class to read and store 
      input from a string
    */

   
	public LinkedList addPolynomial(Node p1,Node p2)
	{
		LinkedList lst = new LinkedList();
		Node temp1 = p1;
		Node temp2 = p2;
		while(temp1 != null)
		{
			lst.addNode(temp1.coef,temp1.powX,temp1.powY,temp1.powZ);
			temp1 = temp1.next;
		}
		while(temp2 != null)
		{
			lst.addNode(temp2.coef,temp2.powX,temp2.powY,temp2.powZ);
			temp2 = temp2.next;
		}
		return lst;
	}


	public LinkedList subPolynomial(Node p1,Node p2)
	{
		LinkedList negative = new LinkedList();
		Node temp = p2;
		while(temp != null)
		{
			negative.addNode(-1*temp.coef,temp.powX,temp.powY,temp.powZ);
			temp = temp.next;
		}
		return addPolynomial(p1,negative.head);
	}


	public LinkedList multiply(Node p1,Node p2)
	{
		Node temp1 = p1;
		Node temp2 = p2;
		LinkedList result = new LinkedList();
		while(temp1 != null)
		{
			while(temp2 != null)
			{
				Node current = multiplyNodes(temp1, temp2);
				result.addNode(current.coef,current.powX,current.powY,current.powZ);
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
			temp2 = p2;
		}
		return result;
	}


	public int evalPolynomial(Node p,EvalArg arg)
	{
		return evalPolynomial(p,arg.x,arg.y,arg.z);
	}

	public int evalPolynomial(Node p,int x,int y, int z)
	{
		int total = 0;
		Node temp = p;
		while(temp != null)
		{
			total += evalNode(temp,x,y,z);
			temp = temp.next;
		}
		return total;
	}


	public int evalNode(Node p,int x,int y, int z)
	{
		return (int) ((int) p.coef * Math.pow(x,p.powX) * Math.pow(y,p.powY) * Math.pow(z,p.powZ));
	}


	public Node multiplyNodes(Node p1, Node p2)
	{
		return new Node(p1.coef * p2.coef,p1.powX+p2.powX,p1.powY+p2.powY,p1.powZ+p2.powZ);
	}

   //this class is how we read input from the .txt file and add them into a Linked List
	public LinkedList getPolynomFromInput(String input) {

		LinkedList temp = new LinkedList();

		boolean isNegative = false;
		boolean doubleDigit = false;
		char digit1 = ' ';
		int counter = 0;
		int finalNum = 0;
		int coef = 0, powX = 0, powY = 0, powZ = 0;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if ((!Character.isLetter(c))) {
				if (Character.isDigit(c)) {
					if (((i + 1) < input.length()) && Character.isDigit(input.charAt(i + 1))) {
						digit1 = c;
						doubleDigit = true;
					} else if (doubleDigit) {
						String combineNum = Character.toString(digit1) + Character.toString(c);

						if (isNegative) {
							finalNum = -Integer.valueOf(combineNum);
							isNegative = false;
						} else {
							finalNum = Integer.valueOf(combineNum);
						}
						doubleDigit = false;
					} else {
						if (isNegative) {
							finalNum = -Character.getNumericValue(c);
							isNegative = false;
						} else {
							finalNum = Character.getNumericValue(c);

						}
					}
				} else if (isNegative) {
					finalNum = -Character.getNumericValue(c);
					isNegative = false;
				} else if (c == '-') {
					isNegative = true;
				} else if (c == '+') {
					isNegative = false;
				} else {
					finalNum = Character.getNumericValue(c);
				}

			}

			if (!isNegative && !doubleDigit && !Character.isLetter(c) && (c != '-') && (c != '+')) {
				switch (counter) {
				case 0:
					coef = finalNum;
					counter++;
					break;
				case 1:
					powX = finalNum;
					counter++;
					break;
				case 2:
					powY = finalNum;
					counter++;
					break;
				case 3:
					powZ = finalNum;
					counter = 0;
					temp.addNode(coef, powX, powY, powZ);
					break;
				}
			}

		}

		return temp;
	}

}