## LinkedList

배열은 접근시간이 가장 빠르다는 장점을 갖고 있지만 크기를 변경할 수 없고 비순차적인 데이터의
추가 또는 삭제의 시간이 많이 걸리는 단점 또한 갖고있다.

LinkedList는 이러한 배열의 단점을 보완하기 위해서 고안되었으며 데이터가 불연속적으로 존재하는
데이터를 서로 연결한 형태로 구성되어있다.

```java
public class LinkedListTest {
	public static void main(String[] args) {
		Node next;  // 다음 요소의 주소를 저장
		Object obj; // 데이터를 저장
	}
}
```

각 LinkedList의 노드들은 자신과 연결된 다음 요소에 대한 참조와 데이터로 구성되어있다.

- 삭제 : 이전 요소가 삭제하고자 하는 요소의 다음 요소를 참조하도록 변경
- 추가 : 새로운 요소를 추가하고자하는 위치의 이전요소의 참조로 변경하고 새로운 요소의 다음 요소를 기존에 있던 요소로 연결해준다.

### Doubly linked list

Doubly linked list는 단순히 일반 LinkedList에서 참조변수를 하나 더 추가하여 이전 요소의 참조가 가능하도록 변경한 것이다.

### Doubly circular linked list

Doubly linked list의 첫번째요소와 마지막 요소를 연결해준 것이다.

### ArrayList LinkedList 비교

- 순차적으로 추가/삭제 하는 경우에는 ArrayList가 LinkedList보다 빠르다.
- 중간 데이터를 추가/삭제하는 경우에는 LinkedList가 ArrayList보다 빠르다.
- 
