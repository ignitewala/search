package com.problem2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.problem2.CommonUtil;

import static org.junit.Assert.*;

public class CommonUtilTest {
 
	@Rule
	  public ExpectedException thrown =  ExpectedException.none();
	
	@Test
	public void when_the_first_set_is_null_raises_error() {
		thrown.expect(RuntimeException.class);
		CommonUtil.findCommon(null, null);
	}
	
	@Test
	public void when_the_2nd_set_is_null_raises_error() {
		thrown.expect(RuntimeException.class);
		CommonUtil.findCommon(new HashSet<>(), null);
	}
	
	@Test
	public void returns_common_integers() {
		
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(1);
		set2.add(2);
		
		assertEquals(set1, CommonUtil.findCommon(set1, set2));
	}
	
	@Test
	public void when_no_common_items_returns_empty_set() {
		
		
		Set<Object> set1 = new HashSet<>();
		set1.add(3);
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(1);
		set2.add(2);
		
		assertTrue(CommonUtil.findCommon(set1, set2).isEmpty());
	}
	
	@Test
	public void returns_common_Strings() {
		
		Set<String> set1 = new HashSet<>();
		set1.add("A");
		
		Set<String> set2 = new HashSet<>();
		set2.add("A");
		set2.add(null);
		
		assertEquals(set1, CommonUtil.findCommon(set1, set2));
	}
}
