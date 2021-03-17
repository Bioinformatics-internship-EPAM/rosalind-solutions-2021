package RosalindTasks;

import java.io.IOException;

public class IPRB {

	public static double solveIPRBTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_iprb.txt").get(0);
		dataSplit = dataSet.split(" ");
		int k = Integer.parseInt(dataSplit[0]);
		int m = Integer.parseInt(dataSplit[1]);
		int n = Integer.parseInt(dataSplit[2]);
		double total = k + m + n;
		double probBothDom = (k/total)*((k-1)/(total-1));
		double probBothHetero = (m/total)*((m-1)/(total-1));
		double probDomRec = ( (k/total)*(n/(total-1)) ) + ((n/total)*(k/(total-1)));
		double probDomHetero = ( (k/total)*(m/(total-1)) ) + ((m/total)*(k/(total-1)));
		double probHeteroRec = ( (m/total)*(n/(total-1)) ) + ((n/total)*(m/(total-1)));

		return probBothDom + probDomHetero + (probBothHetero * 0.75) + probDomRec + (probHeteroRec * 0.5);
	}
	public static void main(String[] args) throws IOException {
		System.out.println(solveIPRBTask());
	}

}
