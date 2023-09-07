package stream;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

class Student {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;

	public Student(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public boolean isMale() {
		return isMale;
	}

	public int getHak() {
		return hak;
	}

	public int getBan() {
		return ban;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s, %d학년, %d반, %3d점]", name, isMale ? "남자" : "여자", hak, ban, score);
	}

	enum Level {HIGH, MID, LOW}
}

public class StreamEx7 {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
			new Student("나자바", true, 1, 1, 300),
			new Student("김지미", false, 1, 1, 250),
			new Student("김자바", true, 1, 1, 200),
			new Student("이지미", false, 1, 2, 150),
			new Student("남자바", true, 1, 2, 100),
			new Student("안지미", false, 1, 2, 50),
			new Student("황지미", true, 1, 3, 100),
			new Student("강자바", false, 1, 3, 150),
			new Student("이자바", true, 1, 3, 200),

			new Student("나자바", true, 1, 1, 300),
			new Student("김지미", false, 1, 1, 250),
			new Student("김자바", true, 1, 1, 200),
			new Student("이지미", false, 1, 2, 150),
			new Student("남자바", true, 1, 2, 100),
			new Student("안지미", false, 1, 2, 50),
			new Student("황지미", true, 1, 3, 100),
			new Student("강자바", false, 1, 3, 150),
			new Student("이자바", true, 1, 3, 200)
		);

		// Map<Boolean, Optional<Student>> topScoreStuBySex = studentStream.collect(
		// 	Collectors.partitioningBy(Student::isMale, maxBy(Comparator.comparingInt(Student::getScore))));
		//
		// System.out.println("남학생 1등 : " + topScoreStuBySex.get(true));
		// System.out.println("여학생 1등 : " + topScoreStuBySex.get(false));

		// Map<Integer, List<Student>> stuByBan = studentStream.collect(Collectors.groupingBy(Student::getBan));

		// Map<Student.Level, Long> stuByLevel = studentStream
		// 	.collect(groupingBy(s -> {
		// 		int score = s.getScore();
		// 		if (score >= 200) {
		// 			return Student.Level.HIGH;
		// 		}
		// 		if (score >= 100) {
		// 			return Student.Level.MID;
		// 		}
		// 		return Student.Level.LOW;
		// 	}, counting()));
		//
		// System.out.println(stuByLevel);

		Map<Integer, Map<Integer, Set<Student.Level>>> stuByHakAndBan = studentStream
			.collect(
				groupingBy(Student::getHak,
					groupingBy(Student::getBan,
						mapping(s -> {
							int score = s.getScore();
							if (score >= 200) {
								return Student.Level.HIGH;
							}
							if (score >= 100) {
								return Student.Level.MID;
							}
							return Student.Level.LOW;
						}, toSet())))
			);

		for (Integer i : stuByHakAndBan.keySet()) {
			System.out.println(stuByHakAndBan.get(i));
		}
	}
}
