package minterms;

import java.util.ArrayList;

public class Fullfunction {


	public ArrayList<String> C = new ArrayList<String>();

	public String[] toBinary(Integer[] array) {
		int counter = 0;
		String[] array2 = new String[array.length];
		for (Integer i : array) {
			array2[counter] = Integer.toBinaryString(i);
			counter++;
		}
		return array2;
	}

	public String[] leadingZeros(String a[], int numberOfVariables) {
		String[] b = new String[a.length];
		for (int counter = 0; counter < a.length; counter++) {
			if (a[counter].length() < numberOfVariables) {
				b[counter] = "";

				for (int i = a[counter].length(); i < numberOfVariables; i++) {
					b[counter] += '0';
				}
				b[counter] += a[counter];
			} else {

				b[counter] = a[counter];

			}
		}
		return b;
	}

	public int[] noOfOnes(String[] array) {
		int[] numOfOnes = new int[array.length];
		String s = new String();
		for (int i = 0; i < array.length; i++) {
			numOfOnes[i] = 0;
			for (int j = 0; j < array[i].length(); j++) {
				s = "" + array[i].charAt(j);
				numOfOnes[i] += Integer.parseInt(s);
			}
		}

		return numOfOnes;

	}

	public String compare(String a, String b) {
		String s = "";
		int counter = 0;
		for (int i = 0; i < b.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				s += a.charAt(i);
			} else {
				counter++;
				s += '-';
			}
		}
		if (counter > 1 || counter == 0) {
			return null;
		}
		return s;
	}

	public ArrayList<String> minimization(ArrayList<String> arrayOfminOutputs) {
		String s;
		ArrayList<String> A = new ArrayList<String>();
		boolean[] visited = new boolean[arrayOfminOutputs.size()];
		for (int i = 0; i < arrayOfminOutputs.size(); i++) {
			visited[i] = false;
		}
		for (int i = 0; i < arrayOfminOutputs.size(); i++) {
			for (int j = 0; j < arrayOfminOutputs.size(); j++) {

				s = compare(arrayOfminOutputs.get(i), arrayOfminOutputs.get(j));
				if (s != null && A.indexOf(s) < 0) {
					A.add(s);

				}
				if (s != null ) {
					visited[i] = true;
					visited[j] = true;
				}

			}
		}

		for (int i = 0; i < arrayOfminOutputs.size(); i++) {
			if (visited[i]!=true ) {
			C.add(arrayOfminOutputs.get(i));
		}
		}
	/*	for (int i = 0; i < arrayOfminOutputs.size(); i++) {

			System.out.println(arrayOfminOutputs.get(i));
		}*/


		return A;
	}

	public ArrayList<String> firstMinimization(int[] noOFones, String[] first) {
		String s;
		boolean[] visited = new boolean [first.length];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		ArrayList<String> A = new ArrayList<String>();
		for (int i = 0; i < noOFones.length; i++) {
			for (int j = 0; j < noOFones.length; j++) {
				if (noOFones[j] == noOFones[i] - 1) {
					s = compare(first[i], first[j]);
					if (s != null) {
						A.add(s);
						visited [i] = true;
						visited [j] = true;
					}
				}

			}
		}
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]!=true ) {
			C.add(first[i]);
		}
		}
		return A;
	}

}
