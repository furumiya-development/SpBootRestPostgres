## :leaves: SpringBootでRESTful API(JSON)、HTTPS通信サンプル

#### 環境
```
開発環境：Eclipse 2020-12 R(4.18.0) Pleiades Spring Tool Suite プラグイン 4.9.0
言語：Java 11
デベロッパーSDK：Adopt OpenJDK 11.0.10 + 9
フレームワーク：Spring Boot 2.4.2
-Spring Framework 5.3.4
-サーブレットエンジン：Apache Tomcat 9.0.41
-テンプレートエンジン：Thymeleaf 3.0.12 RELEASE
-データベース接続：PostgreSQL JDBC 4.2 Driver 42.2.18
-O/R マッパー フレームワーク：Hibernate ORM 5.4.27.Final + JPA 2.2
-ログイン認証:Spring Security 5.5.0-M1  
ログイン認証：Digest認証
データベース：PostgreSQL 13.2
-データベース管理ツール：PgAdmin 4.30
ビルドツール：Apache Maven 3.6.3
```

#### Digest認証／ブラウザ  
![Img](ReadmeImg.png)

#### Digest認証／401レスポンスヘッダー例  
![Img2](ReadmeImg2.png)