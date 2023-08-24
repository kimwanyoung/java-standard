## 제네릭(Generics)

제네릭은 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입 체크를 해주는 기능이다.

### 장점

1. 타입 안정성을 제공한다
2. 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해진다.

### 제네릭 클래스의 선언

```java
class Box<T> {
	T item;

	void setItem(T item) {
		this.item = item;
	}

	T getItem() {
		return this.item;
	}

}
```

Box<T>에서 T를 타입 변수라고 하며, T가 아닌 다른 것을 사용해도 된다. 무조건 T보다는 가능하면 상황에 맞게 의미있는 문자를 선택하여 사용하는 것이 좋다.
제네릭 클래스가 된 Box클래스의 객체를 생성할 때는 참조변수와 생성자 타입에 T대신 사용될 실제 타입을 지정해주어야 한다.

```java
class BoxText {
	public static void main(String[] args) {
		Box<String> b = new Box<String>();
		b.setItem("ABC");

		String item = b.getItem();
	}
}
```

### 제네릭의 제한

1. 모든 객체에 대해 동일하게 동작해야하는 static멤버에 타입변수 T를 사용할 수 없다.
2. 제네릭 배열 타입의 참조변수를 선언하는 것은 가능하지만, new 생성자를 통해 배열을 생성하는 것은 불가능하다. 컴파일 시점에서 T가 어떤 타입인지 알 수 없기 떄문이다.

