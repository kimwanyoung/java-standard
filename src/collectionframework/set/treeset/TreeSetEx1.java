package collectionframework.set.treeset;

import java.util.TreeSet;

public class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();

		String[] stringArr = {"abc", "car", "dance", "elephant", "flower", "alien", "Car", "dZZZZ", "elevator", "bat",
			"disc", "dzzzz", "fan"};
		String from = "b";
		String to = "d";

		for (String s : stringArr) {
			set.add(s.toLowerCase());
		}

		System.out.println(set);
		System.out.println("range search : from " + from + " to " + to);
		System.out.println("result1 : " + set.subSet(from, to));
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));

	}
}
