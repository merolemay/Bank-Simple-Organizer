package linkedList;

public class Main {
	
	public Main() {}
	
	static LinkedList<Integer> solution;
	
	public  static String mazodeCartas(int n) {
		
		solution = new LinkedList<Integer>();
		String s="";
		
		
		
		
		for (int i = n; i > 0; i--) {
			solution.push(i);
		}
		
		while(solution.size()>1) {
			s +=solution.pop()+" ";
			if(solution.size()>1) {
			solution.add(solution.pop());
			} 
		}
		
		
		return s;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Discard Cards: "+mazodeCartas(19));
		System.out.println("Remaning Cards: "+solution.pop());
	}

}
