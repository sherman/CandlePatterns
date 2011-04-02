#!/bin/bash

java -classpath "/home/sherman/.m2/repository/com/beust/jcommander/1.12/jcommander-1.12.jar:/home/sherman/.m2/repository/joda-time/joda-time/1.6.2/joda-time-1.6.2.jar:/home/sherman/.m2/repository/junit/junit/3.8.1/junit-3.8.1.jar:/home/sherman/.m2/repository/log4j/log4j/1.2.16/log4j-1.2.16.jar:/home/sherman/.m2/repository/org/beanshell/bsh/2.0b4/bsh-2.0b4.jar:/home/sherman/.m2/repository/org/testng/testng/6.0/testng-6.0.jar:/home/sherman/.m2/repository/org/yaml/snakeyaml/1.6/snakeyaml-1.6.jar:target/classes" finance.candlePatterns.App $@
