1. 빌드

git clone https://github.com/KunWoong/pirates.git
cd ./pirates
mvn clean package -DskipTests

2. 실행
java -jar ./target/pirates-1.0.jar


h2 console : localhost:8080/h2-console
databaseurl : jdbc:h2:mem:pirates-database


APIs

