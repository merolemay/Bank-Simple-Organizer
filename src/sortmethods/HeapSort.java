package sortmethods;

import model.Client;

public class HeapSort 
{
    private Client[] a;
    private int  n;
    private int left;
    private int right;
    private int largest;

    // Build-Heap Function
    public void buildheap(Client []a){
    	n=a.length-1;
    	for(int i=n/2;i>=0;i--){
    		System.out.println(i);
    		maxheap(a,i);
    	}
    }
    
    // Max-Heap Function
    public void maxheap(Client[] a, int i){
    	
    	left=2*i;
    	right=2*i+1;
    	
    	if(left <= n && a[left].getCc() > a[i].getCc()){
    		largest=left;
    	}
    	else{
    		largest=i;
    	}
    	
    	if(right <= n && a[right].getCc() > a[largest].getCc()){
    		largest=right;
    	}
    	if(largest!=i){
    		exchange(i,largest);
    		maxheap(a, largest);
    	}
    }
    

    
    // Exchange Function
    public void exchange(int i, int j){
    	Client t=a[i];
    	a[i]=a[j];
    	a[j]=t; 
    	}
    
    // Sort Function
    public Client[] sort(Client[] c){
    	int[] id = new int[c.length];
    	for(int i=0;i<c.length;i++) {
    		id[i]=c[i].getCc();
    	}
    	a=c;
    	buildheap(a);
    	
    	for(int i=n;i>0;i--){
    		exchange(0, i);
    		n=n-1;
    		maxheap(a, 0);
    	}
    	return c;
    }

    	
}