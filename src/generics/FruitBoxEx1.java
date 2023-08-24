package generics;

import java.util.ArrayList;

class Fruit {

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

public class FruitBoxEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<>();
		Box<Apple> appleBox = new Box<>();
		Box<Toy> toyBox = new Box<>();
		// Box<Grape> grapeBox = new Box<Apple>();	Error : 타입 불일치

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());

		toyBox.add(new Toy());

		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}
