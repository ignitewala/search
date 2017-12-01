package com.problem2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CommonUtil {

	//TODO: retailAll?
	public static Set<?> findCommon(Set<?> set1, Set<?> set2){
		Objects.nonNull(set1);
		Objects.nonNull(set2);
		
		Set<Object> commonItems = new HashSet<>();
		
		for(Object t: set2){
			if(set1.contains(t)){
				commonItems.add(t);
			}
		}
		return commonItems;
	}
}
