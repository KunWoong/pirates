## 1. 빌드

git clone https://github.com/KunWoong/pirates.git

cd ./pirates

mvn clean package -DskipTests

## 2. 실행

java -jar ./target/pirates-1.0.jar

 설정 내용
h2 console : localhost:8080/h2-console
databaseurl : jdbc:h2:mem:pirates-database


## APIs

#### A. 점포 추가 API
url : localhost:8080/mvc/store
method : POST


#### B. 점포 휴무일 등록 API
url : localhost:8080/mvc/holiday
method : POST


#### C. 점포 목록 조회 API
url : localhost:8080/mvc/list
method : GET


#### D. 점포 상세 정보 조회 API
url : localhost:8080/mvc/store
method : GET
param : id



## 예시

#### A. 점포 추가 API
url : localhost:8080/mvc/store
method : POST
Body : 
{
 "name": "인어수산",
 "owner": "장인어",
 "description": "인천소래포구 종합어시장 갑각류센터 인어수산",
 "level": 2,
 "address": "인천광역시 남동구 논현동 680-1 소래포구 종합어시장 1 층 1 호",
 "phone": "010-1111-2222",
"businessTimes": [
 {
 "day": "Monday",
 "open": "13:00",
 "close": "23:00"
 },
 {
 "day": "Tuesday",
 "open": "13:00",
 "close": "23:00"
 },
 {
 "day": "Wednesday",
 "open": "09:00",
 "close": "18:00"
 },
 {
 "day": "Thursday",
 "open": "09:00",
 "close": "23:00"
 },
 {
 "day": "Friday",
 "open": "09:00",
 "close": "23:00"
 }
 ]
}


{
"name": "해적수산",
 "owner": "박해적",
 "description": "노량진 시장 광어, 참돔 등 싱싱한 고퀄 활어 전문 횟집",
 "level": 1,
 "address": "서울 동작구 노량진동 13-8 노량진수산시장 활어 001",
 "phone": "010-1234-1234",
"businessTimes": [
 {
 "day": "Monday",
 "open": "09:00",
 "close": "24:00"
 },
 {
 "day": "Tuesday",
 "open": "09:00",
 "close": "24:00"
 },
 {
 "day": "Wednesday",
 "open": "09:00",
 "close": "24:00"
 },
 {
 "day": "Thursday",
 "open": "09:00",
 "close": "24:00"
 },
 {
 "day": "Friday",
 "open": "09:00",
 "close": "24:00"
 }
 ]
}

#### B. 점포 휴무일 등록 API
url : localhost:8080/mvc/holiday
method : POST

{ "id": 1,
 "holidays": [
 "2021-06-01",
 "2021-05-30"
 ]
}

#### C. 점포 목록 조회 API
url : localhost:8080/mvc/list
method : GET


#### D. 점포 상세 정보 조회 API
url : localhost:8080/mvc/store
method : GET
param : id
