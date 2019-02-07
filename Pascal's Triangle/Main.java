
//**********************************************************************
//  Main.java      
//  Name: Karan Singh       
//  Student ID: ks572
//  Student Section : CS 505-852
//  PROJECT 5: Pascal's Triangle
//**********************************************************************

public class Main {

    public static void main(String[] args) {

        int n = args.length == 1 ? Integer.parseInt(args[0]) : 1;

        for (int i = 1; i <= n; ++i) 
        {
            int[] arr = Pascal.triangle(i);
            
            System.out.print((i < 10 ? " " : "") + i + ": ");
            
            for (int j : arr) 
            {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}

class Pascal 
{
    public static int[] triangle (int n) 
    
    {

        if (n == 1)
        {
            return new int[] {1};
        }
         
        else if (n == 2)
        {
            return new int[] {1, 1};
        }
       
        else
        {

        int [] newRow = new int [n];
        
        newRow [0] = 1;
        newRow [newRow.length -1] = 1;

        int [] oldRow = triangle (n - 1);

        oldRow[0] = 1;
        oldRow[oldRow.length - 1] = 1;


        int k = 1;
       
        while (k < newRow.length - 1)
        {
            newRow [k] = oldRow [k - 1] + oldRow[k];
            
            k = k + 1;
        }

        return newRow;

        }
    }
}
