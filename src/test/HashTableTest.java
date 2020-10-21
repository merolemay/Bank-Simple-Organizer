package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import HashTable.HashTable;

class HashTableTest {
	
	HashTable<Integer,String> table;
	
	void setUpEmptyHashTable() {
		table = new HashTable<Integer,String>(10);
	}
	
	void setUpHashTable() {
		table = new HashTable<Integer,String>(10);
		table.put(1,"Daniel");
		table.put(2,"Andrew");
		table.put(3,"Carlos");
	}
	
	


	@Test
	void testPut1() {
		setUpEmptyHashTable();
		
		table.put(666,"Capitan Teemo");
		table.put(667,"Capitan Garen");
		table.put(668,"Capitan Ashe");
		
		
		assertTrue(table.getTableLength()==3);
	}
	
	@Test
	void testPut2() {
		setUpHashTable();
		
		table.put(666,"Capitan Teemo");
		table.put(667,"Capitan Garen");
		table.put(668,"Capitan Ashe");
		
		
		assertTrue(table.getTableLength()==6);
	}

	@Test
	void testGet1() {
	
			setUpHashTable();
			
			table.put(666,"Capitan Teemo");
			table.put(667,"Capitan Garen");
			table.put(668,"Capitan Ashe");
			
			assertTrue(table.get(666).equals("Capitan Teemo"));
		
	}
	


	@Test
	void testRemove() {
	
		setUpHashTable();

		table.remove(1);
		table.remove(2);
		table.remove(3);
		
		assertTrue(table.getTableLength()==0);
	
	}



}
