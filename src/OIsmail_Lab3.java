/*
   Data Structures Lab 3 
   @author: Omar Ismail
   4/6/21
  
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Lab 3 reads in two input files, a polynomial and eval .txt file.
The program perforams polynomial addition/subtraction/mulitplication of polynomials
then it evaluates them and outputs them in a .txt file.

*/
public class OIsmail_Lab3 {
	// Main entry point of the program
	public static void main(String args[]) {

		String polynomial;
		BufferedReader input;
		BufferedReader inputEval;
		BufferedWriter output;
		String exp;
		String errorMsg;
		OIsmail_Lab3 project;
		LinkedList polys[] = new LinkedList[5];
		EvalArg evals[] = new EvalArg[5];
		
		project = new OIsmail_Lab3();

		// Check for command line arguments.
		if (args.length != 3) {
			System.out.println("Usage:  java -cp src OIsmail_Lab3 [input polynomials file pathname]" + " [input eval file pathname]" + " [output file pathname]");
			System.exit(1);
		}

		// opening files that will be used for program
		try {
			input = new BufferedReader(new FileReader(args[0]));
			inputEval = new BufferedReader(new FileReader(args[1]));
			output = new BufferedWriter(new FileWriter(args[2]));
		} catch (Exception ioe) {
			System.err.println(ioe.toString());
			return;
		}

		// Also contains potential error codes
		polyMath convert = new polyMath();
		exp = project.readExpression(input);
		String[] repr = {"A", "B", "C", "D"};
		int i = 0;
		while (exp != null) {
			errorMsg = " ";
			if (exp.length() < 4) {
				errorMsg = ("No operator at first index");
				project.writeExpression(errorMsg, output);
			} else if (exp.length() < 3) {
				errorMsg = ("Expression does not meet required minimum length");
				project.writeExpression(errorMsg, output);
			} else {
				String postfixExp = exp;
				polys[i] = convert.getPolynomFromInput(postfixExp);
				project.writeExpression(repr[i]+") "+postfixExp, output);
				i++;
			}
			exp = project.readExpression(input);
		}

		// reads, converts, and writes the polynomials and evaluations in outputfile

		exp = project.readExpression(inputEval);
		int j = 0;
		while (exp != null) {
			evals[j] = new EvalArg(exp);
			j++;
			exp = project.readExpression(inputEval);
		}
		int k = 0;
		LinkedList result;
		
		//A
		k = 0;
		project.writeExpression("\n\nA = "+polys[0].toString(),output);
		project.writeExpression("Evaluations for A: ",output);
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(polys[0].head,evals[k]),output);
			k++;
		}
		//B
		k = 0;
		project.writeExpression("\n\nB = "+polys[1].toString(),output);
		project.writeExpression("Evaluations for B: ",output);
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(polys[1].head,evals[k]),output);
			k++;
		}
		//C
		k = 0;
		project.writeExpression("\n\nC = "+polys[2].toString(),output);
		project.writeExpression("Evaluations for C: ",output);
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(polys[2].head,evals[k]),output);
			k++;
		}
		//D
		k = 0;
		project.writeExpression("\n\nD = "+polys[2].toString(),output);
		project.writeExpression("Evaluations for D: ",output);
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(polys[3].head,evals[k]),output);
			k++;
		}
		//A+B
		result = convert.addPolynomial(polys[0].head,polys[1].head);
		project.writeExpression("\n\nA+B = "+result.toString(),output);
		project.writeExpression("Evaluations for A+B: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//A+C
		result = convert.addPolynomial(polys[0].head,polys[2].head);
		project.writeExpression("\n\nA+C = "+result.toString(),output);
		project.writeExpression("Evaluations for A+C: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//A+D
		result = convert.addPolynomial(polys[0].head,polys[3].head);
		project.writeExpression("\n\nA+D = "+result.toString(),output);
		project.writeExpression("Evaluations for A+D: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//B+C
		result = convert.addPolynomial(polys[1].head,polys[2].head);
		project.writeExpression("\n\nB+C = "+result.toString(),output);
		project.writeExpression("Evaluations for B+C: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//B+D
		result = convert.addPolynomial(polys[1].head,polys[3].head);
		project.writeExpression("\n\nB+D = "+result.toString(),output);
		project.writeExpression("Evaluations for B+D: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//C+D
		result = convert.addPolynomial(polys[2].head,polys[3].head);
		project.writeExpression("\n\nB+C = "+result.toString(),output);
		project.writeExpression("Evaluations for C+D: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//B-A
		result = convert.subPolynomial(polys[1].head,polys[0].head);
		project.writeExpression("\n\nB-A = "+result.toString(),output);
		project.writeExpression("Evaluations for B-A: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//B-D
		result = convert.subPolynomial(polys[1].head,polys[3].head);
		project.writeExpression("\n\nB-D = "+result.toString(),output);
		project.writeExpression("Evaluations for B-D: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		
		//A*B
		result = convert.multiply(polys[0].head,polys[1].head);
		project.writeExpression("\n\nA*B = "+result.toString(),output);
		project.writeExpression("Evaluations for A*B: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}

		//A*C
		result = convert.multiply(polys[0].head,polys[2].head);
		project.writeExpression("\n\nA*C = "+result.toString(),output);
		project.writeExpression("Evaluations for A*C: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//A*D
		result = convert.multiply(polys[0].head,polys[3].head);
		project.writeExpression("\n\nA*D = "+result.toString(),output);
		project.writeExpression("Evaluations for A*D: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//B*A
		result = convert.multiply(polys[1].head,polys[0].head);
		project.writeExpression("\n\nB*A = "+result.toString(),output);
		project.writeExpression("Evaluations for B*A: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//B*C
		result = convert.multiply(polys[1].head,polys[2].head);
		project.writeExpression("\n\nB*C = "+result.toString(),output);
		project.writeExpression("Evaluations for B*C: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//B*D
		result = convert.multiply(polys[1].head,polys[3].head);
		project.writeExpression("\n\nB*D = "+result.toString(),output);
		project.writeExpression("Evaluations for B*D: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}
		//C*D
		result = convert.multiply(polys[2].head,polys[3].head);
		project.writeExpression("\n\nC*D = "+result.toString(),output);
		project.writeExpression("Evaluations for C*D: ",output);
		k = 0;
		while(evals[k] != null)
		{
			project.writeExpression("For "+evals[k].toString() +" expression is "+convert.evalPolynomial(result.head,evals[k]),output);
			k++;
		}

		// Clean up and return to the operating system.
		try {
			input.close();
			inputEval.close();
			output.close();
		} catch (Exception x) {
			System.err.println(x.toString());
		}
		return;

	}

	// Reads prefix expression from input file.
	private String readExpression(BufferedReader input) {

		String text = "";

		try {
			text = input.readLine();
		} catch (IOException iox) {
			System.err.println(iox.toString());
			System.exit(2);
		}
		return text;
	}

	// Writes the postfix expression into output file.
	private void writeExpression(String text, BufferedWriter output) {

		try {
			output.write(text);
			output.newLine();
		} catch (IOException iox) {
			System.err.println(iox.toString());
			System.exit(3);
		}
	}

}
