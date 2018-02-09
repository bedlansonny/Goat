import java.io.*;
import java.util.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(new File("goat.dat"));
        int cases = in.nextInt();

        for (int c = 0; c < cases; c++)
        {
            int n = in.nextInt();
            Heap goatHeap = new Heap(n);
            for (int i = 0; i < n; i++)
            {
                int t = in.nextInt();
                int[] cycle = new int[t];
                for (int j = 0; j < t; j++)
                {
                    cycle[j] = in.nextInt();
                }
                goatHeap.add(new Goat(cycle));
            }

            System.out.println(goatHeap);


        }
    }
}
