package collectionframework.set.treeset;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetLotto {
	public static void main(String[] args) {
		Set set = new TreeSet();

		for (int i = 0; set.size() < 6; i++) {
			set.add((int)(Math.random() * 45) + 1);
		}

		System.out.println(set);
	}
}
