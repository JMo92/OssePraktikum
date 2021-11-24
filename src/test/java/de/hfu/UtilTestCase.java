package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTestCase {

	@Test
	public void testGutFaelle() {
		Util testCase = new Util();
		assertEquals(true, testCase.istErstesHalbjahr(1));
		assertEquals(true, testCase.istErstesHalbjahr(2));
		assertEquals(true, testCase.istErstesHalbjahr(3));
		assertEquals(true, testCase.istErstesHalbjahr(4));
		assertEquals(true, testCase.istErstesHalbjahr(5));
		assertEquals(true, testCase.istErstesHalbjahr(6));
	}

	@Test
	public void testSchlechtFaelle() {
		Util testCase = new Util();
		assertEquals(false, testCase.istErstesHalbjahr(7));
		assertEquals(false, testCase.istErstesHalbjahr(8));
		assertEquals(false, testCase.istErstesHalbjahr(9));
		assertEquals(false, testCase.istErstesHalbjahr(10));
		assertEquals(false, testCase.istErstesHalbjahr(11));
		assertEquals(false, testCase.istErstesHalbjahr(12));
	}


}
