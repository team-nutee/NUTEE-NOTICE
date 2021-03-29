# NUTEE-NOTICE
![NUTEE 구조도](https://user-images.githubusercontent.com/47442178/108618442-96779080-7461-11eb-819e-c8dd855a8070.jpg)
### 서비스 주요 기능
- NUTEE 서비스에 필요한 교내 공지사항 크롤링 
- NUTEE 교내 공지사항 등록시 기기 알림 및, 사용하기 편하게 가공된 공지사항 데이터 api 제공.

### 주요 사용 기술
- Spring Boot
- JSoup
- Spring Data JPA
- MySQL
- Kafka

### 서비스 설계시 고려사항
- 크롤링을 통해 새로 업데이트 된 데이터를 데이터베이스에 추가하고 비동기적으로 NUTEE-에 알림 전파.
- 추후 공지사항의 형식이 게시판 형태로 변경될 수 있는 가능성을 생각하여 MySQL 데이터베이스 선택.
- 자주 추가되고 삭제되는 학교의 필수 공지사항을 학생들이 보기 편한 상태로 제공하기 위한 고려.
