package enums;

enum Transportation {
	BUS(100) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},
	TRAIN(150) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},
	SHIP(200) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},
	AIRPLANE(250) {
		@Override
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	};

	protected final int BASIC_FARE;

	Transportation(int basicFare) {
		this.BASIC_FARE = basicFare;
	}

	public int getBasicFare() {
		return BASIC_FARE;
	}

	abstract int fare(int distance);
}

public class EnumEx3 {
	public static void main(String[] args) {
		System.out.println("BUS fare = " + Transportation.BUS.fare(100));
		System.out.println("TRAIN fare = " + Transportation.TRAIN.fare(100));
		System.out.println("AIRPLANE fare = " + Transportation.AIRPLANE.fare(100));
		System.out.println("SHIP fare = " + Transportation.SHIP.fare(100));
	}
}
