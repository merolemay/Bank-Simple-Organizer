package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Queue.Queue;

class QueueTest {
	
	Queue<String> queue;
	
	
	void setUpQueue() {
		queue = new Queue<String>();
		
		queue.enqueue("Pablo");
		queue.enqueue("Daniel");
		queue.enqueue("Andrea");
	}
	
	
	void setUpEmptyQueue() {
		queue = new Queue<String>();
		
	}
	
	@Test
	void testEnqueue1() {
		setUpQueue();
		
		queue.enqueue("Pablo");
		queue.enqueue("Daniel");
		queue.enqueue("Andrea");
		
		assertTrue(queue.size()==6);
	}
	

	@Test
	void testEnqueue2() {
		setUpEmptyQueue();
		
		queue.enqueue("Pablo");
		queue.enqueue("Daniel");
		queue.enqueue("Andrea");
		
		assertTrue(queue.size()==3);
	}
	
	@Test
	void testDequeue() {
		setUpQueue();		
		assertTrue(queue.dequeue().equals("Pablo"));	
	}

	@Test
	void testIsEmpty1() {
		setUpEmptyQueue();
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void testIsEmpty2() {
		setUpQueue();
		
		assertTrue(!queue.isEmpty());
	}
}
