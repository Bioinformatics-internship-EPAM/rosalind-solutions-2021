package RosalindTasks;

import java.io.IOException;

public class PERM {

	public static void main (String[] args) throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_perm.txt").get(0);
		int num = Integer.parseInt(dataSet);
		int[] toPermutate = new int[num];
		for (int i=0; i< toPermutate.length; i++)
			toPermutate[i] = i + 1;
		System.out.println(numberOfPermutations(num));
		permutations(num, toPermutate);
	}
	
	public static int numberOfPermutations(int num) {
		if (num <= 1)
			return 1;
		else
			return num * numberOfPermutations(num-1);
	}
	
	static void permutations(int n, int[] array)
	{
		if (n==1) {
			for (int i = 0; i < array.length; i++) 
				System.out.print(array[i]+ " ");
				
		        System.out.println();
		        return;
		    }
		    for (int i = 0; i < n; i++) {
		        permutations(n - 1, array);
		        if ((n & 1) == 0) {
		            int tmp = array[i];
		            array[i]   = array[n - 1];
		            array[n - 1] = tmp;
		        } 
		        else {
		            int tmp = array[0];
		            array[0]   = array[n - 1];
		            array[n - 1] = tmp;
		        }
		    }
	}
}
