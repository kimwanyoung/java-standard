package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {
	public static void main(String[] args) {
		Student[] stuArr = {
			new Student("이자바", 3, 300),
			new Student("김자바", 1, 200),
			new Student("박자바", 2, 100),
			new Student("최자바", 2, 150),
			new Student("나자바", 1, 200),
			new Student("홍자바", 3, 290),
			new Student("심자바", 3, 180),
		};

		List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList());
		System.out.println(names);

		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);

		for (Student s : stuArr2) {
			System.out.println(s);
		}

		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap((s) -> s.getName(), s -> s));

		for (String s : stuMap.keySet()) {
			System.out.println(s + " - " + stuMap.get(s));
		}

		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr).collect(Collectors.summingLong(Student::getTotalScore));

		System.out.println("count = " + count);
		System.out.println("totalScore = " + totalScore);

		totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println("totalScore = " + totalScore);

		Optional<Student> topStudent = Stream.of(stuArr)
			.collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));

		System.out.println("topStudent = " + topStudent.get());

	}

}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
