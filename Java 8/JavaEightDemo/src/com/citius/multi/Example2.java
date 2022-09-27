package com.citius.multi;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class luguagebag<E> implements Bag<E>,RandomAccess<E>{

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E[] elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		Bag.super.shuffle();
	}
	
	
}
interface Bag<E>{
	void add(E e);
	E[] elements();
	
	default void shuffle() {
		E[] e= elements();

		System.out.println("some bag code");
	}
}

interface RandomAccess<E>{
	
	E get(int index);
	E[] elements();

	default void shuffle() {
		E[] e= elements();

		System.out.println("some randomaccess code");
	}
}
