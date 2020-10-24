package sortmethods;

import BTS.BST;

public  class SortingMetdos  {

	
	/** Selection  sort generic implementation
	 * @param <E> : Generic use of the array
	 * @param list: the array that is going to be sort
	 */
	public  <E extends Comparable<E>> void selectionSort(E[] list) {
		
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
	
	public <E extends Comparable<E>> void  mergeSort(E[] list,int start,int end) {


        if  (list.length <= 1) {

            throw new IllegalArgumentException("There is only 1 account or is null");

        }else {
            int middle = list.length/2;
            mergeSort(list,start,middle);
            mergeSort(list,middle+1,end);

            merge(list,start,middle,end);

        }


    }

	public <E extends Comparable<E>> void merge(E[] list,int start, int middle, int end) {
		E[] left  = (E[]) new Comparable[middle - start+1];
		E[] right = (E[]) new Comparable[end - middle];

		for (int i = 0; i < left.length; ++i)
			left[i] = list[start+i];

		for (int i = 0; i < right.length; ++i)
			right[i] = list[middle + i+1];

		int leftI= 0;
		int rightI = 0;
		int currentI = 0;

		while (leftI < left.length && rightI < right.length)
		{
			if (( left[leftI]).compareTo( right[rightI]) <= 0)
			{
				list[currentI] = left[leftI];
				leftI++;
			}
			else
			{
				list[currentI] = right[rightI];
				rightI++;
			}
			currentI++;
		}
	
		while (leftI < left.length) {
			currentI++;
			leftI++;
			list[currentI] = left[leftI];
		}

		while (rightI < right.length) {
			currentI++;
			rightI++;
			list[currentI] = right[rightI];
		}
	}
  
	/*
	public static <E,K extends Comparable<K>> void Tree(E[] list) {
		BST<E,K> tree = new BST<E,K>();
		for(int i=0;i<list.length;i++) {
			tree.add(list[i],list
		}
	}
	*/
	
}
