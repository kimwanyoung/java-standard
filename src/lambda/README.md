## 람다식 (Lambda expression)

람다식이란 메서드를 하나의 식으로 표현한 것이다.

```java
import java.util.Arrays;

class LambdaTest {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Arrays.setAll(arr, (i) -> (int)(Math.random() * 5) + 1);
	}
}
```


