package com.design.collections;

public class CustomHashMap<K,V> {

	private Entry<K,V> [] values;
	private int numKeys=0;
	private int size;
	private static final int START_CAPACITY=16;
	private static double  LOAD_THRESHOLD=0.75;
	
	CustomHashMap(){
		values= new Entry[START_CAPACITY];
	}
	
	CustomHashMap(int size){
			this.size=size;
			values = new Entry[size];
	}
	
	public V put(K key, V value) {
		int index= key.hashCode()%size;
		
		if(values[index]==null) {
		values[index]= new Entry<K,V>(key,value);
		numKeys++;
		return  null;
		}
		else { 
			values[index]= new Entry<K,V>(key,value);
			numKeys++;
			return values[index].getValue();
			}
	}
	
	public boolean isEmpty() {
		if(values.length==0) return true;
		return false;
	}
	
	public V get(K key) {
		int index= key.hashCode()%size;
		return values[index].getValue();
	}
	public int getSize() {
		return size;
	}
	
}
