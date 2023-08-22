## Stack과 Queue

### 스택

마지막에 저장한 데이터를 가장 먼저 꺼내게되는 LIFO(Last in First Out)의 구조

### 큐

처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO(First in First Out)의 구조

#### PriorityQueue

Queue 인터페이스의 구현체 중 하나로, 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내게 되는 특징이있다.
그리고 null은 저장할 수 없다.
각 요소를 힙(heap)이라는 자료구조의 형태로 저장한다.

#### Deque

Queue의 변형으로 한쪽 끝으로만 추가/삭제 할 수 있는 Queue와는 달리 Deque(덱, 또는 디큐)은
양쪽 끝에서 추가/삭제가 가능핟.
