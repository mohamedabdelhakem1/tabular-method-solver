package minterms;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	String stepssss;

public String mainfunction (String min,String number) {
		Fullfunction fullfunction = new Fullfunction();

		int i=0;
		int j=0;
		if(number.isEmpty()) {
			return "INVALID INPUT";
		}
		int numberOfVariables = Integer.parseInt(number) ;
		String answer = "";
		String steps = "step1"+"\n"+"group 0"+"\n";

		int counter = 0;

		String [] inputs = min.split(",");


		ArrayList<Integer> minTerms = new ArrayList<Integer>();
		for (String s : inputs) {

			minTerms.add(Integer.parseInt(s));
		/*	if(!java.lang.Character.isDigit(s.charAt(0))) {
				return "INVALID INPUT";
			}*/
			if (Integer.parseInt(s)>(java.lang.Math.pow(2.0, numberOfVariables))||Integer.parseInt(s) < 0) {
				return "INVALID INPUT";
			}
		}

		Integer[] array = new Integer[minTerms.size()];
		array = minTerms.toArray(array);
		Arrays.sort(array);
		String[] array2 = fullfunction.toBinary(array);

		array2 = fullfunction.leadingZeros(array2, numberOfVariables);

		int[] numberOfones = fullfunction.noOfOnes(array2);

		String[] array3 = new String[array2.length];
		counter = 0;
		for ( i = 0; i <= numberOfVariables; i++) {
			for ( j = 0; j < numberOfones.length; j++) {
				if (numberOfones[j] == i) {
					array3[counter] = array2[j];
					counter++;
				}
			}
		}

		for ( i = 0; i < array3.length; i++) {
			if(i != 0) {
			if(numberOfones[i]>numberOfones[i-1]) {
			steps += ("group"+(char)(48+numberOfones[i])+"\n");
			}
			}
			steps += array3[i] + "\n";


		}
		steps += ("\n"+"step2"+"\n");
		Arrays.sort(numberOfones);

		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
		A = fullfunction.firstMinimization(numberOfones, array3);
		for(i=0;i<A.size();i++) {
			steps += (A.get(i)+"\n");

		}

		 counter = 2;
		while (true) {
			B = fullfunction.minimization(A);

			if (B.isEmpty()) {
				break;
			} else {
				steps += ("\n"+"step"+(char)(48+(++counter))+"\n");
				for ( i = 0; i < B.size(); i++) {

					steps += (B.get(i)+"\n");
				}
				A = B;
			}
		}

		stepssss=steps;

		for( i=0;i<fullfunction.C.size();i++) {
			if(A.indexOf(fullfunction.C.get(i))<0) {
				A.add(fullfunction.C.get(i));
			}
		}
		for ( i = 0; i < A.size(); i++) {
			for ( j = 0; j < A.get(i).length(); j++) {
				if (A.get(i).charAt(j) == '0') {

					answer += (char) (65 + j);
					answer += "`";
				} else if (A.get(i).charAt(j) == '1') {

					answer += (char) (65 + j);
				}

			}
			if (i != (A.size() - 1)) {
				answer += "+";
			}

		}

		return answer;

}
}
