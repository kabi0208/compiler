all: 
	java -cp antlr-3.5.3-complete-no-st3.jar org.antlr.Tool myCompiler.g
	javac -cp antlr-3.5.3-complete-no-st3.jar:. *.java
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test testing_programs/sample1.c > result/sample1.ll
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test testing_programs/sample2.c > result/sample2.ll
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test testing_programs/sample3.c > result/sample3.ll
	lli result/sample1.ll
	lli result/sample2.ll
	lli result/sample3.ll
clean:
	rm -f *.tokens
	rm -f *.class
	rm -f *.ll
	rm myCompilerLexer.java
	rm myCompilerParser.java
	