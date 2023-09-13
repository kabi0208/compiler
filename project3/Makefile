all: 
	java -cp antlr-3.5.3-complete-no-st3.jar org.antlr.Tool myChecker.g
	javac -cp antlr-3.5.3-complete-no-st3.jar:. myChecker_test.java
	java -cp antlr-3.5.3-complete-no-st3.jar:. myChecker_test testing_programs/sample1.c
	java -cp antlr-3.5.3-complete-no-st3.jar:. myChecker_test testing_programs/sample2.c
	java -cp antlr-3.5.3-complete-no-st3.jar:. myChecker_test testing_programs/sample3.c
clean:
	rm -f *.tokens
	rm -f *.class
	rm myCheckerLexer.java
	rm myCheckerParser.java
	