package generics;

import java.util.ArrayList;

class Fruits {

	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruits {

	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruits {

	public String toString() {
		return "Grape";
	}
}

class Juice {
	String name;

	public Juice(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
}

class Juicer {
	static Juice makeJuice(FruitBox<? extends Fruits> box) {
		String tmp = "";

		for (Fruits f : box.getList()) {
			tmp += f + " ";
		}

		return new Juice(tmp);
	}
}

public class FruitBoxEx3 {
	public static void main(String[] args) {
		FruitBox<Fruits> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleFruitBox = new FruitBox<>();

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleFruitBox.add(new Apple());
		appleFruitBox.add(new Apple());

		System.out.println(fruitBox);
		System.out.println(appleFruitBox);
	}
}

class FruitBox<T extends Fruits> extends Box<T> {
}

class Box<T> {

	ArrayList<T> list = new ArrayList<>();

	void add(T item) {
		list.add(item);
	}

	T get(int i) {
		return list.get(i);
	}

	ArrayList<T> getList() {
		return list;
	}

	int size() {
		return list.size();
	}

	public String toString() {
		return list.toString();
	}

}
