package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4 {
	public static void main(String[] args) {
		Stream<String[]> strArrStream = Stream.of(new String[] {"abc", "def", "jkl"},
			new String[] {"ABC", "GHI", "JKL"});

		// Stream<Stream<String>> strStreamStream = strArrStream.map(Arrays::stream); -> 스트림의 스트림을 반환하게 됨
		Stream<String> stringStream = strArrStream.flatMap(Arrays::stream);

		stringStream.map(String::toUpperCase).distinct().sorted().forEach(System.out::println);
		System.out.println();

		String[] lineArr = {"Believe or not Is is true", "Do or do not Threr is no try"};
		Stream<String> lineStream = Arrays.stream(lineArr);

		lineStream.flatMap(line -> Stream.of(line.split(" +")))
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();

		Stream<String> strStream1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStream2 = Stream.of("bbb", "aaa", "ccc", "dd");

		Stream<Stream<String>> strStrmStrm = Stream.of(strStream1, strStream2);
		Stream<String> strStream = strStrmStrm.map(s -> s.toArray(String[]::new)).flatMap(Arrays::stream);

		strStream.map(String::toLowerCase).distinct().forEach(System.out::println);
	}
}
