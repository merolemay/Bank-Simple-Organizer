package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linkedList.LinkedList;

class LinkedListTest {
	
	LinkedList<Integer> list;
	void setUpLinketList() {
		list = new LinkedList<Integer>(0);
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		
	}
	
	void setUpEmptyLinkedList() {	
		list = new LinkedList<Integer>(0);
		
		list.pop();
	}


	@Test
	void testPush() {
		setUpEmptyLinkedList();
		
		list.push(1);
		list.push(2);
		
		assertTrue(list.size()==2);
	}

	@Test
	void testPeek() {
		setUpLinketList();
		
		
		assertTrue(list.peek().equals(0));
	}

	@Test
	void testPop() {
		setUpLinketList();
		
		assertTrue(list.pop().equals(0)&& list.size()==9);
	}

	@Test
	void testIsEmpty1() {
		setUpEmptyLinkedList();
	
		assertTrue(list.isEmpty());
	}
	
	@Test
	void testIsEmpty2() {
		setUpLinketList();
		
		assertTrue(!list.isEmpty());
	}

	@Test
	void testAdd() {
		setUpEmptyLinkedList();
		
		list.add(1);
		list.add(2);
		
		assertTrue(list.size()==2);
	}


	@Test
	void testClear() {
		setUpLinketList();
		
		list.clear();
		assertTrue(list.isEmpty());
	}

}
