/*
   Data Structures Lab 3 
   @author: Omar Ismail
   4/10/21
  
*/

//For evaluation of already manipulated polynomials
//This class is mainly for writing in .txt
public class EvalArg {
    int x;
    int y;
    int z;

    EvalArg(){}


    EvalArg(int x, int y, int z)
    {
        this.x = x; 
        this.y = y; 
        this.z = z;
    }


    EvalArg(String txt)
    {
        int i = txt.indexOf("y");
        int j = txt.indexOf("z");
        this.x = Integer.parseInt(txt.substring(1,i));
        this.y = Integer.parseInt(txt.substring(i+1,j));
        this.z = Integer.parseInt(txt.substring(j+1));
    }

    //for writing in output file
    @Override
    public String toString()
    {
        return "x = " + x + ", y = " + y + ", z = " + z;
    }
}
