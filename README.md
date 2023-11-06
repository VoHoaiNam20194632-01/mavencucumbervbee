# Selenium Java Project With Cucumber [Vbee]

### Mục lục

[I. Mở đầu](#Modau)

[II. Cài Đặt](#caidat)
- [1. JDK](#JDK)
- [2. Cài đặt Intellij IDEA](#intellij)
- [3.  Maven Dependency](#dependency)

[III. Cấu Trúc Project](#cautrucproject)
- [1. Cấu Trúc Project](#project)
- [1. Cấu Trúc src](#src)
[Tổng kết](#TongKet)

===========================

<a name="Modau"></a>
## I. Mở đầu
Đây là project thực hiện Automation test AI VOICE Studio sử dụng Selenium với ngôn ngữ lập trình Java. Sử dụng theo hướng BDD sử dụng framework Cucumber.

<a name="caidat"></a>
## II. Cài Đặt
Cài đặt các môi trường để bắt đầu thực hiện Project

<a name="JDK"></a>
### 1. Cài đặt JDK

Bạn cần cài đặt JDK 21 tại đây
```
https://www.oracle.com/java/technologies/downloads/#jdk21-windows
```

<a name="intellij"></a>
### 2. Cài đặt Intellij IDEA
Bạn cần cài đặt Intellij tại đây
```
https://www.jetbrains.com/idea/download/?section=windows
```
Sau khi cài đặt xong tiếp theo sẽ khởi tạo Project với Maven, thêm đầy đủ JDK đã cài đặt phía trên.
<a name="dependency"></a>
### 3. Maven Dependency

Cần thêm các <dependency> ở pom.xml 

    ```
  	<dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.14.1</version>
        </dependency>
	<dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.5.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.7.1</version>
        </dependency>


        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.14.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>7.14.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-gherkin -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-gherkin</artifactId>
            <version>7.14.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>gherkin</artifactId>
            <version>27.0.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.9</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-simple -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.0.9</version>
            <scope>test</scope>
        </dependency>
    ```
Sau khi thêm vào pom.xml thì lưu lại và cần kiểm tra ở External Libraries xem đã được thêm các Libraries đầy đủ chưa.

<a name="cautrucproject"></a>
## III. Cấu trúc Project

<a name="project"></a>
### 1. Cấu trúc Project 
    .
    ├── .idea                   
    ├── src                     # Source files 
    ├── target 			# Nơi xuất báo cáo các test case
    ├── pom.xml 		# Chứa các dependency 
    └── README.md
    
<a name="src"></a>
### 2. Cấu trúc src

    .
    ├── ...
    ├── src                     
    │   ├── main    
    		└── java
      		└── resources 
    │   ├── test  
    		└── java					# chứa các thứ liên quan đến xử lý logic ...
      			└── StepDifinitions 			# chứa các file java của các test
	 				└── StepsLogin.java	# các bước Steps Login
      		└── resources 
			    └── Feature 			# chứa các kịch bản kiểm thử
       					└── Login.feature 	# kịch bản kiểm thử login 
    └── ...

Ví Dụ : 
	Kịch bản kiểm thử Login .

  ```
@SmokeFeature
Feature: feature  to test login functionality

  @login
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And confirm capcha
    And click on login button
    And click on studio button
    And click x
    And click No
    Then user is navigated to the home page

    Examples:
      | username | password |
      | vonam0561@gmail.com | 24081201Nam@ |
```

<a name="TongKet"></a>
## Tổng kết 

Bài viết trên là tổng quát về project, nhưng thứ chi tiết sẽ đước cập nhật ở báo cáo.

Liên lạc của tôi:

- Email: vohoainam650@gmail.com

Xin chân thành cảm ơn!
