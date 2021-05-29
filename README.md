## 1. 빌드

git clone https://github.com/KunWoong/pirates.git

cd ./pirates

mvn clean package -DskipTests

## 2. 실행

java -jar ./target/pirates-1.0.jar

 설정 정보
 
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

