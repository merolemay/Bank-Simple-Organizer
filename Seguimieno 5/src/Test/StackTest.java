package Test;

import Stack.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;



class StackTest {
	
	Stack s;
	
	@Before
	void setUp1() {
		s = new Stack();
	}
	
	@Before
	void setUp2() {
		s = new Stack<Integer>(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
	}
	
	@Before
	void setUp3() {
		s = new Stack<String>("Ricardo");
		s.push("Carlos");
		s.push("Daniel");
		s.push("Andrea");
	}
	
	//Test is the IsEmpty can tell if the stacks is empty when the stack is empty
	@Test
	void testIsEmpty1() {
		setUp1();
		assertTrue(s.isEmpty()==true);
	}
	
	//Test is the IsEmpty can tell if the stacks is empty when the stack has one element
	@Test
	void testIsEmpty2() {
		setUp2();
		assertTrue(s.isEmpty()==false);
	}
	//Test is the IsEmpty can tell if the stacks is empty when the stack has more than one element
	@Test
	void testIsEmpty3() {
		setUp2();
		assertTrue(s.isEmpty()==false);
	}
	
	//Test if the method push works when the stack is empty
	@Test
	void testPush1() {
		setUp1();
		s.push(299);
		assertEquals(299,s.pop());
	}
	
	//Test if the method push works when the stack has elements
	@Test
	void testPush2() {
		setUp2();
		s.push(299123);
		assertEquals(299123,s.pop());
	}
	
	//Test if the method push works when the stack has elements of a diferent type(String)
		@Test
		void testPush3() {
			setUp3();
			s.push(299123);
			assertEquals(299123,s.pop());
		}
	
	//Test if the pop works when the element is a number when there is only one element in the stack
	@Test
	void testPop1() {
		setUp2();
		assertEquals(4,s.pop());
	}
	
	//Test if the pop works when the element is a String
	@Test
	void testPop2() {
		setUp3();
		assertEquals("Andrea",s.pop());
	}
	
	//Test if  the method pop deletes the element of the stack
	@Test
	void testPop3() {
		setUp2();
		while(s.isEmpty()==false) {
			s.pop();
		}
		assertTrue(s.isEmpty());
	}
	
	//Test if the peek method works when the element is a number 
	@Test
	void testPeek1() {
		setUp2();
		assertEquals(4,s.peek());
	}
	
	//Test if the peek method works when the element is a String
	@Test
	void testPeek2() {
		setUp3();
		assertEquals("Andrea",s.peek());
	}
	
	//Test if the method peek doesn't deletes the last element from the stack
	@Test
	void testPeek3() {
		setUp2();
		s.peek();
		assertTrue(s.isEmpty()==false);
	}
	

}
