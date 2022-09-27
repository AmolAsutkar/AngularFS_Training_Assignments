package iteratorpattern;

import java.util.Iterator;

class SimpleStack<V> implements Iterable<V> {
	
	class Node{
		V value;
		Node below;
		
		Node(V value){
			this.value = value;
			below = top;
		}
	}
	
	private Node top;
	
	public void push(V item) {
		top = new Node(item);
	}
	
	public V pop() {
		V item = top.value;
		top = top.below;	
		return item;
	}
	
	public boolean empty() {
		return top == null;
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<V>() {
			Node current = top;
			
			public boolean hasNext() {
				return current != null;
			}
			
			public V next() {
				V data = current.value;
				current = current.below;
				return data;
			}
		};
	}
}

public class IteratorDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleStack<String> names = new SimpleStack<>();
		names.push("Jack");
		names.push("Jill");
		names.push("John");
		names.push("Jeff");
		/*
		while(!names.empty())
			System.out.println(names.pop());
		System.out.println("-------------------------------");
		while(!names.empty())
			System.out.println(names.pop());
		*/
		String[] strNames = {"A", "B"};
		for (String str : strNames) {
			System.out.println(str);
		}
		
		for (String name : names) {
			System.out.println(name);
		}
	}

}
