package collectionframework.set.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetEx4 {
	public static void main(String[] args) {
		Set set = new HashSet();

		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));

		System.out.println(set);

	}
}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person)obj;
			return this.name.equals(p.name) && this.age == p.age;

		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.age);
	}

	@Override
	public String toString() {
		return name + " : " + age;
	}
}
