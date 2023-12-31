## Thread

### 프로세스와 쓰레드

#### 프로세스(process) : 실행중인 프로그램을 뜻함 프로그램을 실행하면 OS로부터 실행에 필요한 자원을 할당받아 프로세스가 됨.

- 프로세스
    - 데이터, 메모리 자원
    - 데이터, 메모리 자원 이용해서 실제 작업 수행하는 쓰레드

모든 프로세스에는 최소한 하나 이상의 쓰레드가 존재. 둘 이상 쓰레드를 가지면 멀티쓰레드 프로세스라고 함.

### 멀티 쓰레딩의 장단점

#### 장점

- CPU의 사용률을 향상 시킨다.
- 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성이 향상된다.
- 작업이 분리되어 코드가 간결해진다.

#### 단점

- 동기화
- 교착상태

### 싱글 쓰레드와 멀티 쓰레드

#### 하나의 쓰레드 : 한 작업을 마친 후에 다른 작업을 시작한다.

#### 두 개의 쓰레드 : 번갈아 가면서 작업을 수행해서 동시에 두 작업이 처리되는 것 처럼 느낌

#### 시간 : 한 개 < 두 개

- 쓰레드간 작업 전환(컨텍스트 스위칭)에 시간이 걸리기 때문이다.

### 쓰레드의 우선 순위

쓰레드는 우선순위라는 속성을 가지고 있는데, 이 우선순위의 값에따라 쓰레드가 얻는 실행 시간이 달라진다.
쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속받는다.

### 쓰레드 그룹

쓰레드 그룹은 서로 관련된 쓰레드를 그룹으로 다루기 위한 것으로, 쓰레드 그룹을 생성해서 쓰레드를 그룹으로 묶어서 관리할 수 있다.
자바 어플리케이션이 실행되면, JVM은 main과 system이라는 쓰레드 그룹을 만들고 JVM운영에 필요한 쓰레드들을 생성해서 이 쓰레드 그룹에 포함시킨다.

### 데몬 쓰레드

다른 일반쓰레드의 작업을 돋는 보조적인 역할을 수행하는 쓰레드이다.\
ex) 가비지 컬렉터, 워드 프로세서의 자동저장, 화면 자동갱신\
무한루프와 조건문을 이용해서 실행 후 대기하고 있다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.

### 쓰레드의 실행제어

#### 쓰레드의 생성 ~ 소멸

1. 쓰레드를 생성하고 start()를 호출하면 바로 실행되는 것이 아니라 실행 대기열에 저장되어 자신의 차례를 기다린다. 실행 대기열은 큐와 같은 구조로 먼저 실행대기열에 들어온 쓰레드가 먼저 실행된다.
2. 실행대기상태에 있다가 자신의 차례가 되면 실행상태가 된다.
3. 주어진 실행시간이 다 되거나 yield()를 만나면 다시 실행 대기상태가 되고, 다음 차례의 쓰레드가 실행된다.
4. 실행중에 I/O block에 의해서 일시정지상태가 될 수 있다. 이런경우 일시 정지 상태에 있다가 일시정지가 해제되면 다시 실행 대기 상태가 된다.
5. 지정된 일시정지 시간이 다 되거나(time-out), notify(), resume(), interrupt()가 호출되면 일시정지 상태를 벗어나 다시 실행대기열에 저장되어 자신의 차례를 기다리게된다.
6. 실행을 모두 마치거나 stop()이 호출되면 쓰레드는 소멸된다.
