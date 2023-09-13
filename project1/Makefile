all: 
	java -jar antlr-3.5.3-complete-no-st3.jar  mylexter.g
	javac -cp ./antlr-3.5.3-complete-no-st3.jar  testLexer.java mylexter.java
	java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample1.c > testing_programs/output1.txt
	java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample2.c > testing_programs/output2.txt
	java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample3.c > testing_programs/output3.txt
	java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample1.c
	java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample2.c
	java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample3.c
clean:
	rm -f *.tokens
	rm -f *.class
	rm mylexter.java