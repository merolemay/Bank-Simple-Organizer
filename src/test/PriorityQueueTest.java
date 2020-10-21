package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import priorityQueue.PriorityQueue;

class PriorityQueueTest {
	PriorityQueue<String> queue;
	
	void setUpPriorityQueue() {
		queue = new PriorityQueue<String>(10);
		
		queue.add("Camile", 1);
		queue.add("Daniel", 3);
		queue.add("Carlos", 2);
	
	}
	
	void setUpEmptyPriorityQueue() {
		queue = new PriorityQueue<String>(10);
		
	}

	@Test
	void testPop1() {
		
		setUpPriorityQueue();
		
		queue.add("Capitan Teemo", 6);
		queue.add("Capitan Ashe", 8);
		queue.add("Capitan Garen", 7);
		
		
		assertTrue(queue.pop().equals("Capitan Ashe"));
		
	}
	
	@Test
	void testPop2() {
		
		setUpEmptyPriorityQueue();
		
		queue.add("Capitan Teemo", 6);
		queue.add("Capitan Ashe", 8);
		queue.add("Capitan Garen", 7);
		
		
		assertTrue(queue.pop().equals("Capitan Ashe"));
		
	}

	@Test
	void testAdd1() {
		setUpPriorityQueue();
		
		queue.add("Capitan Teemo", 6);
		queue.add("Capitan Garen", 7);
		queue.add("Capitan Ashe", 8);
		
		assertTrue(queue.getSize()==5);
	}
	
	@Test
	void testAdd2() {
		setUpEmptyPriorityQueue();
		
		queue.add("Capitan Teemo", 6);
		queue.add("Capitan Garen", 7);
		queue.add("Capitan Ashe", 8);
		

		assertTrue(queue.getSize()==2);
	}


	@Test
	void testRemove() {
			
			setUpPriorityQueue();
			
			queue.add("Capitan Teemo", 6);
			queue.add("Capitan Ashe", 8);
			queue.add("Capitan Garen", 7);
			
			queue.remove();
			
			assertTrue(queue.pop().equals("Capitan Garen"));
			
		
	}

	@Test
	void testIsEmpty1() {
		setUpEmptyPriorityQueue();
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void testIsEmpty2() {
		setUpPriorityQueue();
		
		assertTrue(!queue.isEmpty());
	}

}
