/**
 * 
 */
package com.smallestmessingelt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Arnaud
 *
 */
public class SmallestMissingElt {

	/**
	 * @param args
	 */
	
	public int solution (int[] A) { 
		int val = 1;
		Set<Integer> A_without_duplication = new HashSet<>();
		
		// Copy the table data in the set to eliminate eventual data duplication.
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				A_without_duplication.add(A[i]);  
			}
		}
		
		List<Integer> sorted_A = new ArrayList();
		
		// Copy data in a List so that it can be sorted
		sorted_A.addAll(A_without_duplication);
		
		// Sort the data in an ascending order
		Collections.sort(sorted_A);  
		
		if (!sorted_A.isEmpty()) {  // If all the elements of the original array where < 0, we end up with an empty list, which is not worth being manipulated.  
			for (int i = 1; i <= sorted_A.get(sorted_A.size() - 1); i++) {
				if (!sorted_A.contains(i)) {
					val = i;
					break;                
				}
				if (i == sorted_A.get(sorted_A.size() - 1) && val == 1) {
					val = sorted_A.get(sorted_A.size() - 1) + 1;
				}
			}
		}
		
		return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int A[] = {1,3,6,4,1,2};  // The following arrays can be tested as well: {1,2,3} and {-1,-3} 
        SmallestMissingElt smallestMissingElt = new SmallestMissingElt();
        System.out.println("Smallest positive integer: " + smallestMissingElt.solution(A));
	}
}
