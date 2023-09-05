package enums;

enum Direction {
	EAST(1, ">"),
	SOUTH(2, "V"),
	WEST(3, "<"),
	NORTH(4, "^");

	private static final Direction[] DIR_ARR = Direction.values();
	private final int value;
	private final String symbol;

	Direction(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}

	public static Direction of(int dir) {
		if (dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value : " + dir);
		}
		return DIR_ARR[dir - 1];
	}

	public Direction rotate(int num) {
		num = num % 4;

		if (num < 0) {
			num += 4;
		}

		return DIR_ARR[(value - 1 + num) % 4];
	}

	public int getValue() {
		return this.value;
	}

	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public String toString() {
		return name() + getSymbol();
	}
}

public class EnumEx2 {
	public static void main(String[] args) {
		for (Direction d : Direction.values()) {
			System.out.println(d.name() + " = " + d.getSymbol());
		}

		Direction d1 = Direction.EAST;
		Direction d2 = Direction.of(1);

		System.out.printf("d1 = %s, %d%n", d1.name(), d1.getValue());
		System.out.printf("d2 = %s, %d%n", d2.name(), d2.getValue());

		System.out.println(Direction.EAST.rotate(1));
		System.out.println(Direction.EAST.rotate(2));
		System.out.println(Direction.EAST.rotate(-1));
		System.out.println(Direction.EAST.rotate(-2));
	}
}
