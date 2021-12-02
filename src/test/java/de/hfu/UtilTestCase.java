package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTestCase {

	/**
    * Teste ob istErstesHalbjahr funktioniert.
    */
   @Test
   public void testErstesHalbjahr() {
       assertTrue(Util.istErstesHalbjahr(1));
       assertTrue(Util.istErstesHalbjahr(6));
       assertFalse(Util.istErstesHalbjahr(7));
       assertFalse(Util.istErstesHalbjahr(12));
   }
   /**
    * Teste ob Ausnahme bei 0 geworfen wird.
    */
   @Test(expected=IllegalArgumentException.class, timeout=1000) 
   public void testUngueltigeEingabe0() { 
       Util.istErstesHalbjahr(0);
   }
   /**
    * Teste ob Ausnahme bei 13 geworfen wird.
    */
   @Test(expected=IllegalArgumentException.class, timeout=1000) 
   public void testUngueltigeEingabe13() { 
       Util.istErstesHalbjahr(13);
   }

}
