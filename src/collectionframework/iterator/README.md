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

## ListIterator, Enumeration

***Enumeration*** : Iteration의 구 버젼 이전버전과의 호환성 위해서 남겨 두고 있다.\
***ListIteration*** : Iterator를 상속받아 기능을 추가한 것으로, 요소에 접근할 때 Iterator은 단방향으로 접근할 수 있는데, ListIterator는 양방향으로의 이동이 가능하다.
ArrayList, LinkedList와 같이 List인터페이스를 구현한 컬렉션에서만 사용가능


