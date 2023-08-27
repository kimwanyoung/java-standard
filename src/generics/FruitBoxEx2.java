/*
package generics;

import java.util.ArrayList;

interface Eatable {
}

class Fruit implements Eatable {

	@Override
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {

	@Override
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {

	@Override
	public String toString() {
		return "Grape";
	}
}

class Toy {

	@Override
	public String toString() {
		return "Toy";
	}
}

class Box<T> {
	ArrayList<T> list = new ArrayList<>();

	void add(T item) {
		list.add(item);
	}

	T getItem(int index) {
		return this.list.get(index);
	}

	int size() {
		return this.list.size();
	}

	@Override
	public String toString() {
		return this.list.toString();
	}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {
}

public class FruitBoxEx2 {
	public static void main(String[] args) {

	}
}
*/
