# 프로젝트

Date: 2023년 5월 24일
이번주: Yes
즐겨찾기: No

1. 루트 등록때 로그인 필요 기능 구현, JWT 토큰 / 세션스토리지 저장값으로 확인

토큰 처리 및 새로운 객체로 변환 후 Controller로 전송 → myRoute객체 수정

1. myRoute및 RouteController 삭제, myPlan, PlanController로 대체 및 SQL 쿼리 작업, DB 변경

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20b464c9febbf349d2a3f83b4b9d8acbd5/Untitled.png)

기본 DB user 테이블 제약조건 변경, PK 꼬이고 인덱스 꼬인거 다 지우고 다시 재설정

myPlan 객체를 받아서, MySQL에 하나는 myPlan으로, 하나는 myPlanOrder로 저장하겠음.

//myPlan 객체로 왔다. 이걸 파싱해서 하나는 myPlan으로, 하나는 myPlanOrder로 보내야 함
/*
myPlan : myplanno(자동), userid, userno, triptitle, myplanlike, myplanhit
myplanOrder : myplanno(받아와야 함), title, addr, first_image, expecttime
*/

```
	//myPlan 저장
	//현재 최대 myPlan값 가져오기
	//order 저장 (myPlan값)

```

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20b464c9febbf349d2a3f83b4b9d8acbd5/Untitled%201.png)

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20b464c9febbf349d2a3f83b4b9d8acbd5/Untitled%202.png)

해당 DB 분리, BE-FE 저장 완료

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20b464c9febbf349d2a3f83b4b9d8acbd5/Untitled%203.png)

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20b464c9febbf349d2a3f83b4b9d8acbd5/Untitled%204.png)

1. 마커 좌측 클릭 이벤트 및 예상 시간 측정
- 클릭 : 해당 마커 좌표 습득
- DB의 my_plan_order의 좌표와 비교하여 my_plan_no값을 찾아낸다.
- my_plan_no값으로 해당 게시글을 찾아낸다.

클릭 시 여행계획 추가(여행계획 탭 아닐 경우 알림 창 추가) : 완료

마커 간 거리 측정 : Haversine 공식 사용

거리를 토대로 select 입력 이동수단(자동차 : 60, 자전거 : 20, 도보 : 5 km)을 토대로 예상 소모 시간 산출

예상 시간 측정 : 

소수점 두자리 분 단위로 출력 가능하게

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20b464c9febbf349d2a3f83b4b9d8acbd5/Untitled%205.png)

DB 수정

---

style not scoped → 

SearchMap

temp.vue