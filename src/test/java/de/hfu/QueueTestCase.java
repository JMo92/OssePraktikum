package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTestCase {
	/**
	 * Tests for Queue
	 */
	@Test
	public void testQueue() {
		try {
			@SuppressWarnings("unused")
			Queue x = new Queue(0);
			fail("Die erwartete Ausnahme wurde nicht geworfen.");
		}
		catch (IllegalArgumentException e) {}
		
		Queue q = new Queue(3);
		
		try {
			q.dequeue();
			fail("Die erwartete Ausnahme wurde nicht geworfen.");
		}
		catch (IllegalStateException e) {}
		
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		assertTrue(q.dequeue() == 0);
		assertTrue(q.dequeue() == 1);
		assertTrue(q.dequeue() == 3);
		
		
		try {
			q.dequeue();
			fail("Die erwartete Ausnahme wurde nicht geworfen.");
		}
		catch (IllegalStateException e) {}
	
	}

}
