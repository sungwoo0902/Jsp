<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<property name="NAME" value="Ch11"/>	
	<property name="LOG_DIR" value="/logs"/>
	
	<!-- 콘솔 어펜더 -->
	<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
		<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
			<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>
	
	<!-- 파일 어펜더 -->
	<appender name="FILE" class="ch.qos.logback.core.FileAppender">
		<file>${LOG_DIR}/${NAME}.log</file>
		<append>true</append>
		<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
			<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>
	
	<!-- 롤링 어펜더(일자별) -->	 
	<appender name="ROLLING_DAILY" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">	    
			<fileNamePattern>${LOG_DIR}/${NAME}-%d{yyyy-MM-dd}.log</fileNamePattern>
		</rollingPolicy>
		<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
			<pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>
	
	<!-- 롤링 어펜더(크기별) -->	 
	<appender name="ROLLING_SIZE" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>${LOG_DIR}/${NAME}.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
			<fileNamePattern>${LOG_DIR}/${NAME}-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
			<timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
				<maxFileSize>1MB</maxFileSize>
				<maxHistory>7</maxHistory>
			</timeBasedFileNamingAndTriggeringPolicy>
		</rollingPolicy>
		<encoder>
			<pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>
  
	<root level="debug">
		<appender-ref ref="STDOUT" />
		<appender-ref ref="ROLLING_DAILY" />
	</root>
</configuration>