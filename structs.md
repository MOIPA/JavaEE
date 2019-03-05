# Struts2 learn
----
### Configuration
#### basic configuration

 1. 使用intellij 默认的maven项目管理依赖

 2. 配置maven源镜像为国内阿里

 3. pom.xml中添加以下依赖

     1. 在properties中添加struct和log4j变量

        ```xml
          <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        
            <struts2.version>2.5.14.1</struts2.version>
            <log4j2.version>2.10.0</log4j2.version>
        
          </properties>
        ```

        	2. 添加具体日志和struct依赖

        ```xml
        
            <dependency>
              <groupId>org.apache.struts</groupId>
              <artifactId>struts2-core</artifactId>
              <version>${struts2.version}</version>
            </dependency>
        
            <dependency>
              <groupId>org.apache.logging.log4j</groupId>
              <artifactId>log4j-core</artifactId>
              <version>${log4j2.version}</version>
            </dependency>
            <dependency>
              <groupId>org.apache.logging.log4j</groupId>
              <artifactId>log4j-api</artifactId>
              <version>${log4j2.version}</version>
            </dependency>
        
        ```

    3. 添加运行插件

       ```xml
       
               <plugin>
                 <groupId>org.eclipse.jetty</groupId>
                 <artifactId>jetty-maven-plugin</artifactId>
                 <version>9.4.7.v20170914</version>
                 <configuration>
                   <webApp>
                     <contextPath>/${build.finalName}</contextPath>
                   </webApp>
                   <stopKey>CTRL+C</stopKey>
                   <stopPort>8999</stopPort>
                   <scanIntervalSeconds>10</scanIntervalSeconds>
                   <scanTargets>
                     <scanTarget>src/main/webapp/WEB-INF/web.xml</scanTarget>
                   </scanTargets>
                 </configuration>
               </plugin>
       ```

    4. 在intellij 中添加maven命令，命令格式：jetty:run

------

#### project structure

 1. 添加java文件夹：src/main/java/<packageName>/controller 和dao层  

    这里的view是: src/main/webapp/index.jsp

 2. 添加拦截器：用于将所有url访问拦截给struts框架 在src/main/resources/struts.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    
    <!DOCTYPE struts PUBLIC
            "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
            "http://struts.apache.org/dtds/struts-2.5.dtd">
    <struts>
        <constant name="struts.devMode" value="true" />
    
        <package name="basicstruts2" extends="struts-default">
            <action name="index">
                <result>/index.jsp</result>
            </action>
            <action name="hello" class="com.tr.controller.HelloWorldAction" method="execute">
                <result name="success">/HelloWorld.jsp</result>
                <result name="error">/error.jsp</result>
            </action>
        </package>
    </struts>
    ```

    

 3. 添加log4j的配置：src/main/resources/log4j2.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration>
        <Appenders>
            <Console name="STDOUT" target="SYSTEM_OUT">
                <PatternLayout pattern="%d %-5p [%t] %C{2} (%F:%L) - %m%n"/>
            </Console>
        </Appenders>
        <Loggers>
            <Logger name="com.opensymphony.xwork2" level="debug"/>
            <Logger name="org.apache.struts2" level="debug"/>
            <Root level="warn">
                <AppenderRef ref="STDOUT"/>
            </Root>
        </Loggers>
    </Configuration>
    
    
    ```

----



#### example

1. 在webapp下添加index.jsp

   1. ```html
      <!DOCTYPE html>
      <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <%@ taglib prefix="s" uri="/struts-tags"%>
      <html>
      <head>
          <meta charset="UTF-8">
          <title>Basic Struts 2 Application - Welcome</title>
      </head>
      <body>
      <h1>Welcome To Struts 2!</h1>
      <p><a href="<s:url action='hello'/> ">Link to hello</a> </p>
      
      <s:url action="hello" var="helloLink">
          <s:param name="userName">Bruce Phillips</s:param>
      </s:url>
      
      <p><a href="${helloLink}">Hello Bruce Phillips</a></p>
      
      
      </body>
      </html>
      
      ```

      

2. 在webapp下添加HelloWorld.jsp

   ```html
   <%--
     Created by IntelliJ IDEA.
     User: tr
     Date: 19-3-4
     Time: 下午4:18
     To change this template use File | Settings | File Templates.
   --%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <%@ taglib prefix="s" uri="/struts-tags"%>
   <html>
   <head>
       <title>hello world</title>
   </head>
   <body>
       <h2><s:property value="messageStoreSuccess.message" /></h2>
   </body>
   </html>
   
   ```

3. 在webapp下添加error.jsp

   ```html
   <%--
     Created by IntelliJ IDEA.
     User: tr
     Date: 19-3-5
     Time: 上午10:06
     To change this template use File | Settings | File Templates.
   --%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <%@ taglib prefix="s" uri="/struts-tags" %>
   <html>
   <head>
       <title>error page</title>
   </head>
   <body>
       <h1>error info <s:property value="messageStoreError.message"/></h1>
   </body>
   </html>
   
   ```

   

4. 在java包内的controller文件夹建立HelloWorldAction.java

   ```java
   package com.tr.controller;
   
   import com.opensymphony.xwork2.ActionSupport;
   import com.tr.dao.MessageStore;
   
   import java.util.Random;
   
   /***
    * @author tr
    */
   public class HelloWorldAction extends ActionSupport {
   
       private MessageStore messageStoreSuccess = null;
       private MessageStore messageStoreError = null;
       private int count = 1;
       private int mgNumber = 2;
   
       @Override
       public String execute() throws Exception {
           Random random = new Random();
           count = random.nextInt();
           if(count%mgNumber==0){
               messageStoreSuccess = new MessageStore("Welcome you are the: "+count);
               return SUCCESS;
           }
           else {messageStoreError = new MessageStore("error count value is: " + count);
           return ERROR;}
       }
   
       public MessageStore getMessageStoreSuccess() {
           return messageStoreSuccess;
       }
   
       public MessageStore getMessageStoreError() {
           return messageStoreError;
       }
   
   
   }
   
   ```

   

5. 在java包内的dao文件夹建立MessageStore.java

   ```java
   package com.tr.dao;
   
   /**
    * @author tr
    */
   public class MessageStore {
       private String message;
   
       public MessageStore(String message) {
           this.message = message;
       }
   
       public String getMessage() {
           return message;
       }
   
   }
   
   ```

6. 运行maven命令 输入 url   类似 0.0.0.:8080/<ProjectName>/index.action

----

### Taglib

#### url tag with param

```html

<s:url action="hello" var="helloLink">
  <s:param name="userName">Bruce Phillips</s:param>
</s:url>

<p><a href="${helloLink}">Hello Bruce Phillips</a></p>
```

这会产生url的参数 ？userName=Bruce Phillips



#### struts2 form tag

```html
<p>Get your own personal hello by filling out and submitting this form.</p>

<s:form action="hello">
  <s:textfield name="userName" label="Your name" />
  <s:submit value="Submit" />
</s:form>
```

这会产生一个post请求到./hello.action

#### struts2 property tag

``` html
<s:property value="messageStore.message" />
```

自动调用对应action的getMessageStore方法 再获取内部message

注意的是每个url请求对应的action对象不同，如果希望这些不同对象同享变量，变量要加static

**如果getMessageStore返回的messageStore对象执行他的.method()返回不同结果**

 	1. 返回的是string 不做变换
 	2. 返回的是int 变为string
 	3. 返回的是对象，自动调用toString

----

### Coding actions

