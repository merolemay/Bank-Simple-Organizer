package sortmethods;

import BTS.*;

public  class SortingMetdos {
	
	/** Selection  sort generic implementation
	 * @param <E> : Generic use of the array
	 * @param list: the array that is going to be sort
	 */
	public static <E extends Comparable<E>> void selectionSort(E[] list) {
		
		 for(int i=0; i<list.length -1; i++) {
			 
	            int iSmallest = i;

	            for(int j=i+1; j<list.length; j++)
	            {
	                if(list[iSmallest].compareTo((list[j])) > 0  )
	                {
	                    iSmallest = j;
	                }
	            }
	            E iSwap = list[iSmallest];
	            list[iSmallest] = list[i];
	            list[i] = iSwap;
	     
	        }
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		//Alex acabar!!
		
	}
	
	public static <E extends Comparable<E>> void Tree(E[] list) {
		BTS<E> tree = new BTS<E>();
		for(int i=0;i<list.length;i++) {
			tree.addNode(list[i]);
		}
	}
	
	

}
