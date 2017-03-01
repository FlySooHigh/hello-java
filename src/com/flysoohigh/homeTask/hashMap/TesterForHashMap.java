package com.flysoohigh.homeTask.hashMap;

public class TesterForHashMap 
{
	private int value;

	TesterForHashMap(int value)
	{
		this.value = value;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		TesterForHashMap other = (TesterForHashMap) obj;
		if (value != other.value) return false;
		return true;
	}
	
	
}
