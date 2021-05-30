## 1. 빌드

git clone https://github.com/KunWoong/pirates.git

cd ./pirates

mvn clean package -DskipTests

## 2. 실행

java -jar ./target/pirates-1.0.jar


 설정 정보
 
h2 console : localhost:8080/h2-console

databaseurl : jdbc:h2:mem:pirates-database


## Table DDL

``` sql
create table business_time (id integer not null, close varchar(255), day integer, open varchar(255), store_id integer, primary key (id))

create table holiday (id integer not null, day varchar(255), store_id integer, primary key (id))

create table store (id integer not null, address varchar(255), description varchar(255), level integer not null, name varchar(255), owner varchar(255), phone varchar(255), primary key (id))

alter table business_time add constraint business_time_fk_constraint foreign key (store_id) references store

alter table holiday add constraint holiday_fk_constraint foreign key (store_id) references store
```


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

#### E. 점포 삭제 API
url : localhost:8080/mvc/store

method : DELETE

param : id


## APIs Example


#### A. 점포 추가 API
url : localhost:8080/mvc/store

method : POST

##### Sample-1

Request Body :
```json
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
```

##### Sample-2

Reqeust Body:

```json
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
```

#### B. 점포 휴무일 등록 API
url : localhost:8080/mvc/holiday

method : POST


##### Sample-1

Request Body : 

```json
{
 "id": 1,
 "holidays": [
 "2021-05-29",
 "2021-05-30"
 ]
}
```

#### C. 점포 목록 조회 API
url : localhost:8080/mvc/list

method : GET

   ##### Sample-1

   localhost:8080/mvc/list


#### D. 점포 상세 정보 조회 API
url : localhost:8080/mvc/store

method : GET

params :
         key : id

   ##### Sample-1

   localhost:8080/mvc/store?id=1

#### E. 점포 삭제 API
url : localhost:8080/mvc/store

method : DELETE

params :
         key : id

   ##### Sample-1

   localhost:8080/mvc/store?id=1
