<?xml version="1.0" encoding="UTF-8"?>
<Configuration xmlns="https://logging.apache.org/xml/ns"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:schemaLocation="
                   https://logging.apache.org/xml/ns
                   https://logging.apache.org/xml/ns/log4j-config-2.xsd">
  <Appenders>
    <Console name="CONSOLE">
      <PatternLayout pattern="%p - %m%n"/>
    </Console>
    <File name="MAIN" fileName="logs/main.log">
      <JsonTemplateLayout/>
    </File>
    <File name="DEBUG_LOG" fileName="logs/debug.log">
      <PatternLayout pattern="%d [%t] %p %c - %m%n"/>
    </File>
  </Appenders>
  <Loggers>
    <Root level="INFO">
      <AppenderRef ref="CONSOLE" level="WARN"/>
      <AppenderRef ref="MAIN"/>
    </Root>
    <Logger name="org.example" level="DEBUG">
      <AppenderRef ref="DEBUG_LOG"/>
    </Logger>
  </Loggers>
</Configuration>