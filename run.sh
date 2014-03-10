#!/bin/bash
javac src/*.java
java -cp src/ App
rm src/*.class
