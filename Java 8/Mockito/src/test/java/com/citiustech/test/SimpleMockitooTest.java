package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleMockitooTest {

	@Test
	void test() {
		
		ArrayList<String>  mocklist=Mockito.mock(ArrayList.class);
		/*
		 * mocklist.add("java"); mocklist.add("python"); mocklist.add("c++");
		 */
		
		Mockito.when(mocklist.size()).thenReturn(3);
		assertEquals(3,mocklist.size());
		
		ArrayList<String> spylist=Mockito.spy(new ArrayList<>());
		spylist.add("java");
		spylist.add("python");
		spylist.add("c++");

			assertEquals(3,spylist.size());
			Mockito.when(spylist.size()).thenReturn(5);
			assertEquals(5,spylist.size());

	}

}
