package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Fruit {
	String name;
	int weight;

	public Fruit(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return name + "( " + weight + " ) ";
	}
}

class Apple extends Fruit {
	public Apple(String name, int weight) {
		super(name, weight);
	}
}

class Grape extends Fruit {
	public Grape(String name, int weight) {
		super(name, weight);
	}
}

class FruitComp implements Comparator<Fruit> {
	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o1.weight - o2.weight;
	}
}

public class FruitBoxEx4 {
	public static void main(String[] args) {
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Grape> grapeBox = new FruitBox<>();

		appleBox.add(new Apple("GreenApple", 300));
		appleBox.add(new Apple("GreenApple", 200));
		appleBox.add(new Apple("GreenApple", 100));

		grapeBox.add(new Grape("GreenGrape", 300));
		grapeBox.add(new Grape("GreenGrape", 200));
		grapeBox.add(new Grape("GreenGrape", 100));

		Collections.sort(appleBox.getList(), new FruitComp());
		Collections.sort(grapeBox.getList(), new FruitComp());
		System.out.println(appleBox);
		System.out.println(grapeBox);
	}
}

class FruitBox<T extends Fruit> extends Box<T> {

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
