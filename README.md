﻿## :leaves: SpringBootでRESTful API(JSON)、HTTPS通信サンプル

#### 環境
```
開発環境：Eclipse 2021-03 R(4.19.0) Pleiades Spring Tool Suite プラグイン 4.10.0
言語：Java 11
デベロッパーSDK：Adopt OpenJDK 11.0.10 + 9
フレームワーク：Spring Boot 2.4.4
-Spring Framework 5.3.5
-サーブレットエンジン：Apache Tomcat 10.0.0-M1
-テンプレートエンジン：Thymeleaf 3.0.12 RELEASE
-データベース接続：PostgreSQL JDBC 4.2 Driver 42.2.19
-O/R マッパー フレームワーク：Hibernate ORM 5.4.29.Final + JPA 2.2.3
-ログイン認証:Spring Security 5.5.0-M3  
ログイン認証：Digest認証
データベース：PostgreSQL 13.2
-データベース管理ツール：PgAdmin 5.1
ビルドツール：Apache Maven 3.6.3
```

#### Digest認証／ブラウザ  
![Img](ReadmeImg.png)

#### Digest認証／401レスポンスヘッダー例  
![Img2](ReadmeImg2.png)