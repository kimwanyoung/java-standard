## Iterator

컬렉션에 저장된 요소들을 읽어오는 표준화된 방법
컬렉션 클래스에 대해 iterator()를 호출하여 Iterator를 얻은 다음 반복문으로 컬렉션 클래스의 요소들을 읽어 올 수 있다.

````java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class IteratorTest {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Iterator it = c.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
} 
````

Map 인터페이스는 key, value의 쌍으로 저장하고 있기 때문에 직접 호출할 수 없고, keySet()이나 entrySet()을 통해 Set의 형태를 얻어
iterator()를 호출 할 수 있다.

