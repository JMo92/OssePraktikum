package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTestCase {
	/**
    * Tests for Queue
    */
   @Test
   public void testQueue() {
       Queue q = new Queue(3);
       q.enqueue(0);
       q.enqueue(-1);
       q.enqueue(2);
       q.enqueue(3);

       assertTrue(q.dequeue() == 0);
       assertTrue(q.dequeue() == -1);
       assertTrue(q.dequeue() == 3);
   }
   /**
    * Teste ob Ausnahme bei Queue mit groeße 0 geworfen wird.
    */
   @Test(expected=IllegalArgumentException.class, timeout=1000) 
   public void test0Queue() { 
       Queue x = new Queue(0);
   }
   /**
    * Teste ob Ausnahme bei dequeue (groeße 0) geworfen wird.
    */
   @Test(expected=IllegalStateException.class, timeout=1000) 
   public void testIllegalDequeue() { 
       Queue q = new Queue(3);
       q.dequeue();
   }

}
