all: 
	java -cp antlr-3.5.3-complete-no-st3.jar org.antlr.Tool myparser.g
	javac -cp antlr-3.5.3-complete-no-st3.jar:. testParser.java
	java -cp antlr-3.5.3-complete-no-st3.jar:. testParser testing_programs/sample1.c > testing_programs/output1.txt
	java -cp antlr-3.5.3-complete-no-st3.jar:. testParser testing_programs/sample2.c > testing_programs/output2.txt
	java -cp antlr-3.5.3-complete-no-st3.jar:. testParser testing_programs/sample3.c > testing_programs/output3.txt
	java -cp antlr-3.5.3-complete-no-st3.jar:. testParser testing_programs/sample1.c
	java -cp antlr-3.5.3-complete-no-st3.jar:. testParser testing_programs/sample2.c
	java -cp antlr-3.5.3-complete-no-st3.jar:. testParser testing_programs/sample3.c
clean:
	rm -f *.tokens
	rm -f *.class
	rm myparserLexer.java
	rm myparserParser.java
	