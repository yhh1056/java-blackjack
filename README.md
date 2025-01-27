# java-blackjack

블랙잭 미션 저장소

## 연료 주입 - 자동차 렌트

### 기능 구현 목록
- [x] 주행 거리로 자동차를 생성한다.
- [x] 주행거리로 자동차가 필요한 연료량을 계산한다.    
- [x] 회사는 렌터카를 보유한다.
- [x] 회사는 렌트한 차량에 대해 연료량 레포트를 생성한다.


## 블랙잭

### 게임 용어
처음 받는 카드의 합이 21인 경우 블랙잭이라고 한다.

`Hit` : 카드를 더 받겠다는 뜻

`Stay` : 카드를 그만 받겠다는 뜻


### 기능 요구 사항
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
게임을 완료한 후 각 플레이어별로 승패를 출력한다.


### 게임 결과
```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
hoho, bom, pobi
딜러, hoho, bom, pobi에게 2장의 카드를 나누었습니다.
딜러카드: K스페이드
hoho카드: 4스페이드, A하트
bom카드: 5다이아몬드, 10클로버
pobi카드: 7다이아몬드, 8하트

hoho는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
hoho카드: 4스페이드, A하트, 8다이아몬드
hoho는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
hoho카드: 4스페이드, A하트, 8다이아몬드, 4다이아몬드
hoho는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
bom는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
bom카드: 5다이아몬드, 10클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
pobi카드: 7다이아몬드, 8하트
딜러카드: K스페이드, 9스페이드 - 결과: 19
hoho카드: 4스페이드, A하트, 8다이아몬드, 4다이아몬드 - 결과: 17
pobi카드: 7다이아몬드, 8하트 - 결과: 15
bom카드: 5다이아몬드, 10클로버 - 결과: 15

## 최종 승패
딜러: 3승 0패 0무
hoho: 패
bom: 패
pobi: 패
```

### 기능 구현 목록
#### 인풋
- [x] 참여할 사람의 이름을 입력받는다.
  - [x] 쉼표 기준으로 이름을 분리한다.
  - [x] 이름 앞뒤로 공백을 제거한다.
- [x] 참여자에게 카드를 받을지 유무를 입력받는다.
  - [x] 입력이 y 또는 n인지 검증한다.
  - [x] 입력 앞뒤로 공백을 제거한다.
  - [x] 대문자일 경우 소문자로 치환한다.
- [x] 카드를 더 받을지 입력받는다.

#### 아웃풋
- [x] 첫 라운드에 딜러가 보유한 1장의 카드를 출력한다.
- [x] 첫 라운드에 참여자가 보유한 카드를 출력한다.
- [x] 참여자의 이름과 보유한 카드를 출력한다.
- [x] 딜러가 한장의 카드를 받는지 여부를 출력한다.
- [x] 딜러가 보유한 카드와 숫자의 합을 출력한다.
- [x] 참여자가 보유한 카드와 숫자의 합을 출력한다.
- [x] 딜러의 승패를 출력한다.
- [x] 참가자의 승패를 출력한다.

#### 블랙잭
- [x] 문양과 숫자로 한 장의 카드를 생성한다.
- [x] 52장의 카드를 생성한다
- [x] 52장의 카드 뭉치에서 카드 한장을 꺼낸다.
    - [x] 카드를 꺼낼 수 있는지 검증한다.
- [x] 첫 라운드에 딜러는 2장의 카드를 받는다.
- [x] 이름으로 참여자들을 생성한다.
    - [x] 플레이어의 이름이 공백인지 검증한다.
    - [x] 플레이어의 이름이 딜러인지 검증한다.
- [x] 첫 라운드에 참여자들은 2장의 카드를 받는다.
- [x] 카드를 더 받는다고 할 경우 본인의 패에 카드를 추가한다.
    - [x] 카드 숫자의 합이 21이 넘는지 검증한다.
- [x] 딜러의 카드 합이 16이하일 경우 1장의 카드를 받는다.
- [x] 카드의 합을 계산한다.
    - [x] King, Queen, Jack은 10으로 계산한다.
    - [x] Ace는 1 또는 11로 계산한다.
    - [x] Ace는 21을 넘지않고 가까운 수로 계산한다.
- [x] 딜러와 참여자의 승패를 비교한다.
    - [x] 딜러의 합과 참여자들의 합을 비교한다.
    - [x] 카드의 합이 21이 넘을 경우 패배한다.
