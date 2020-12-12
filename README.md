## :leaves: SpringBootでRESTful API(JSON)、HTTPS通信サンプル

#### 環境
```
開発環境：Eclipse 2020-09 R(4.17.0) Pleiades Spring Tool Suite プラグイン 4.8.1
言語：Java 11
デベロッパーSDK：Adopt OpenJDK 11.0.9
フレームワーク：Spring Boot 2.4.1
-Spring Framework 5.3.2
-サーブレットエンジン：Apache Tomcat 9.0.41
-テンプレートエンジン：Thymeleaf 3.0.11 RELEASE
-データベース接続：PostgreSQL JDBC 4.2 Driver 42.2.18
-O/R マッパー フレームワーク：Hibernate ORM 5.4.25.Final + JPA 2.2
-ログイン認証:Spring Security 5.4.2  
ログイン認証：Digest認証
データベース：PostgreSQL 13.1
-データベース管理ツール：PgAdmin 4.29
ビルドツール：Apache Maven 3.6.3
```

#### Digest認証／ブラウザ  
![Img](ReadmeImg.png)

#### Digest認証／401レスポンスヘッダー例  
![Img2](ReadmeImg2.png)