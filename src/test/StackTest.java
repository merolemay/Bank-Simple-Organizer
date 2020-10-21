package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Stack.Stack;

class StackTest {
	Stack<String> stack;
	
	
	void setUpStack() {
		stack = new Stack<String>();
		
		stack.push("Thing");
		stack.push("Magical");
		stack.push("a");
		stack.push("Not");
		
	}
	
	void setUpEmptyStack() {
		stack = new Stack<String>();	
	}
	

	@Test
	void testPush1() {
		setUpStack();
		
		stack.push("Pablo");
		stack.push("Daniel");
		stack.push("Andrea");
		
		assertTrue(stack.size()==7);
	}
	
	@Test
	void testPush2() {
		setUpEmptyStack();
		
		stack.push("Pablo");
		stack.push("Daniel");
		stack.push("Andrea");
		
		assertTrue(stack.size()==3);
	}

	@Test
	void testPop1() {
		setUpStack();
		
		assertTrue(stack.pop().equals("Not"));
	}
	
	@Test
	void testPop2() {
		setUpStack();
		
		stack.push("Pablo");
		stack.push("Daniel");
		stack.push("Andrea");
		stack.push("Pablo");
		stack.push("Daniel");
		stack.push("Andrea");
		stack.push("Pablo");
		stack.push("Daniel");
		stack.push("Andrea");
		
		assertTrue(stack.pop().equals("Andrea"));
	}
	@Test
	void testPeek1() {
		setUpStack();
		int r = stack.size();
		
		assertTrue(stack.peek().equals("Not") && r==stack.size());
	}
	
	@Test
	void testPeek2() {
		setUpEmptyStack();
		
		stack.push("Andrea");
		stack.push("Pablo");
		stack.push("Daniel");
		stack.push("Andrea");
		
		int r = stack.size();
		
		assertTrue(stack.peek().equals("Andrea") && r==stack.size());
	}


	@Test
	void testIsEmpty1() {
		setUpEmptyStack();
		
		assertTrue(stack.isEmpty());
	}

	@Test
	void testIsEmpty2() {
		setUpStack();
		
		assertTrue(!stack.isEmpty());
	}

}
