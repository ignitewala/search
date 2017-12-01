package com.search.problem1;

import java.util.ArrayList;
import java.util.List;

public class Test {



	public List<String> capitalize(List<String> list) {
		List<String> result = new ArrayList<>();
		for(String x : list){
			result.add(""+Character.toUpperCase(x.charAt(0)) +x.substring(1, x.length()));
			
		}
		return result;
	}
	
	public List<Integer> convert(List<Integer> list) {
		List<Integer> convertedList = new ArrayList<>();
		list.forEach(i ->convertedList.add(i*2));
		
		return convertedList;
	}
	
	public static void main(String[] args) {
		List<String> listStr = new ArrayList<>();
		listStr.add("apple");
		listStr.add("banana");
		System.out.println(new Test().capitalize(listStr));
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		System.out.println(new Test().convert(list));
	}
}
