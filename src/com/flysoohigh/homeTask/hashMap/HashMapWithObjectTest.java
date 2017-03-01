package com.flysoohigh.homeTask.hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapWithObjectTest 
{

	public static void main(String[] args) 
	{
		Map<TesterForHashMap, String> map = new HashMap<>();
		TesterForHashMap k = new TesterForHashMap(1);
		map.put(k, "one");
		k.setValue(11);
		System.out.println(map.get(k));
	}

}
