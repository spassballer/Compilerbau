all: clean javalexer.java javaparser.java sources.txt spezifikation moveclasses yyTokenclass.class javascanner.class main.class test

clean:
	rm -f *.class javalexer.java javaparser.java sources.txt

javalexer.java: javalexer
	java -cp JLex2.jar JLex2.Main javalexer

javaparser.java: javaparser.jay skeleton.jaooy
	jaooy -v -t  javaparser.jay < skeleton.jaooy > javaparser.java

sources.txt:
	find ./semantic_check/ -name "*.java" > sources.txt

spezifikation: sources.txt
	javac -encoding iso-8859-1 -cp asm-7.1.jar @sources.txt

moveclasses:
	mv semantic_check/*.class .

yyTokenclass.class: javaparser.java
	javac javaparser.java

javascanner.class: javalexer.java
	javac javalexer.java

main.class: Main.java yyTokenclass.class javascanner.class
	javac Main.java

test:
	java -cp "asm-7.1.jar:." Main < testfiles/BinaryTest.java
	java -cp "asm-7.1.jar:." Main < testfiles/UnaryTest.java
	java -cp "asm-7.1.jar:." Main < testfiles/IfTest.java
	java -cp "asm-7.1.jar:." Main < testfiles/WhileTest.java
	java -cp "asm-7.1.jar:." Main < testfiles/InstVarTest.java

