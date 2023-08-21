## String클래스

### 변경 불가능한(immutable) 클래스

```java
public final class String implements java.io.Serializable, Comparable {
	private char[] value;
    ...
}
```

문자열 저장 위해서 char 배열 참조변수 value를 인스턴스 변수로 정의해놓고 있다. 인스턴스 생성 시 생성자의 매개변수로 입력받는 문자열은
이 인스턴스 변수(value)에 char[]로 저장된다.
한 번 생성된 String 인스턴스가 갖고 있는 문자열은 읽어올 수만 있고, 변경할 수는 없다.

### 문자열 비교

```java
class StringTest {
	public static void main(String[] args) {
		String str = "abc";
		String str1 = "abc";

		String str3 = new String("abc");
	}
}
```

String 클래스의 생성자를 이용한 경우에는 new 연산자에 의해서 메모리 할당이 이루어지기 때문에
항상 새로운 String 인스턴스가 생성되지만, 문자열 리터럴은 이미 존재하는 것을 재사용한다.

- str1, str2는 같은 주소값을 갖고 있고 str3는 새로운 인스턴스가 생성되어 다른 주소값을 가지고 있다.

#### 문자열 리터럴

자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장된고, 같은
내용의 문자열 리터럴은 한번만 저장된다. 문자열 리터럴도 String인스턴스이고, 한 번 생성하면 내용을
변경할 수 없으니 하나의 인스턴스를 공유하면 되기 때문이다.  
클래스 파일에는 소스파일에 포함된 모든 리터럴의 목록이 있다. 해당 클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때,
이 리터럴의 목록에 있는 리터럴들이 JVM내에 있는 '상수 저장소(constant pool)'에 저장된다.
이 곳에 문자열 리터럴이 자동적으로 생성되어 저장되는 것이다.

### 문자열 변환

#### 기본형 값을 String으로 변환

```java
class ConvertPrimitiveToString {
	public static void main(String[] args) {
		int i = 100;
		String str1 = i + "";
		String str2 = String.valueOf(i);
	}
}
```

#### String을 기본형 값으로 변환

```java
class ConvertStringToPrimitive {
	public static void main(String[] args) {
		String str = "100";
		int i = Integer.parseInt(str);
		int i2 = Integer.valueOf(str);
		// 내부에서 parseInt 호출
		// 결국 같은 메서드
	}
}
```

## StringBuffer 클래스와 StringBuilder 클래스

String 클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없지만, StringBuffer클래스는 변경이 가능하다.
내부적으로 문자열 편집을 위한 버퍼(Buffer)를 가지고 있으며, StringBuffer인스턴스를 생성할 때 그 크기를 지정할 수 있다.

***버퍼*** : 데이터를 한 곳에서 다른 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리 영역

### StringBuffer의 변경

```java
class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");

		sb.append("123");

		StringBuffer sb2 = sb.append("ZZ");

		System.out.println(sb);
		System.out.println(sb2);
	}
}
```

append()는 반환타입이 StringBuffer인데 자신의 주소를 반환한다. 그렇기 떄문에 append()문장이
수행되면, sb에 새로운 문자열이 추가되고 sb자신의 주소를 반환하여 sb2에는 sb의 주소가 저장된다.

### StringBuilder란?

StringBuffer은 멀티쓰레드에 안전하도록 동기화 되어있다. 멀티쓰레드로 작성된 프로그램이 아닌경우, StringBuffer의 동기화는
불필요하게 성능만 떨어뜨리게 된다. 그래서 StringBuffer에서 쓰레드 동기화만 뺀 StringBuilder가 새로 추가되었다.
StringBuffer과 완전히 똑같은 기능으로 작성되어있다.
