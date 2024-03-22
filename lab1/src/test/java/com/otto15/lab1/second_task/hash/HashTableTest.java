package com.otto15.lab1.second_task.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashTableTest {
    private HashTable<Integer> hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    @DisplayName("Successfully add elements to the hash table")
    public void testAdd() {
        hashTable.add(10);
        assertEquals(1, hashTable.getSize());

        hashTable.add(20);
        assertEquals(2, hashTable.getSize());
    }

    @Test
    @DisplayName("Successfully remove elements from the hash table")
    public void testRemove() {
        hashTable.add(10);
        hashTable.add(20);

        hashTable.remove(10);
        assertEquals(1, hashTable.getSize());
        assertNull(hashTable.find(10));
    }

    @Test
    @DisplayName("Successfully find elements in the hash table")
    public void testFind() {
        hashTable.add(10);
        hashTable.add(20);

        assertEquals(Integer.valueOf(10), hashTable.find(10));
        assertEquals(Integer.valueOf(20), hashTable.find(20));
        assertNull(hashTable.find(30));
    }

    @Test
    @DisplayName("Table is not empty after adding a value")
    public void testIsEmpty() {
        assertTrue(hashTable.isEmpty());
        hashTable.add(10);
        assertFalse(hashTable.isEmpty());
    }

    @Test
    @DisplayName("Normally remove non-existent element")
    public void testRemoveNonExistent() {
        assertNull(hashTable.remove(10));
    }

    @Test
    @DisplayName("Successfully rehash the table")
    public void testRehashing() {
        for (int i = 0; i < 100; i++) {
            hashTable.add(i);
        }
        assertEquals(100, hashTable.getSize());

        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i), hashTable.find(i));
        }
    }

    @Test
    @DisplayName("Successfully add null to the hash table")
    public void testAddNull() {
        hashTable.add(null);
        assertEquals(1, hashTable.getSize());
        assertNull(hashTable.find(null));
    }

    @Test
    @DisplayName("Successfully remove null from the hash table")
    public void testRemoveNull() {
        hashTable.add(null);
        hashTable.remove(null);
        assertEquals(0, hashTable.getSize());
        assertNull(hashTable.find(null));
    }

    @Test
    @DisplayName("Successfully find null in the hash table")
    public void testFindNull() {
        hashTable.add(null);
        assertNull(hashTable.find(null));
    }
}
