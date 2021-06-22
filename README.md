## :leaves: SpringBootでRESTful API(JSON)、HTTPS通信サンプル

#### 環境
```
開発環境：Eclipse 2021-06 R(4.20.0) Pleiades Spring Tool Suite プラグイン 4.11.0
言語：Java 11
デベロッパーSDK：Adopt OpenJDK 11.0.11 + 9
フレームワーク：Spring Boot 2.5.1
-Spring Framework 5.3.8
-サーブレットエンジン：Apache Tomcat 10.0.0-M1
-テンプレートエンジン：Thymeleaf 3.0.12 RELEASE
-データベース接続：PostgreSQL JDBC 4.2 Driver 42.2.20
-O/R マッピング フレームワーク：Hibernate ORM 5.4.32.Final + JPA 2.2.3
-ログイン認証:Spring Security 5.5.1  
ログイン認証：Digest認証
データベース：PostgreSQL 13.3
-データベース管理ツール：PgAdmin 5.4
ビルドツール：Apache Maven 3.8.1
```

#### Digest認証／ブラウザ  
![Img](ReadmeImg.png)

#### Digest認証／401レスポンスヘッダー例  
![Img2](ReadmeImg2.png)