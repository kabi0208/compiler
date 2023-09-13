Project 3: Static Type Checker
409410024 資工三 陳品希

注意事項：
    1. 需先安裝"antlr-3.5.3-complete-no-st3.jar"，並置於當前資料夾
        若要用其他ANTLR的話，需為v3，並修改makefile中的名稱
    2. 3個test program皆放在test program資料夾內，按順序檔名分別為'sample1.c'~'sample3.c'
    3. 程式需在Linux或Unix-like環境下執行，需有java的compiler，需有openjdk，需有llvm
    4. 產生的ll檔會放在result資料夾內，按順序檔名分別為'sample1.ll'~'sample3.ll'
    5. 詳細功能寫在word檔裡面

如何編譯執行：
    1. 在Terminal 移動到當前資料夾位置後，輸入 'make'即可，輸出結果可直接於Terminal看
    2. 輸入make clean可清除編譯執行中除output之外的所有檔案
    3. makefile講解:
        編譯執行：
            java -cp antlr-3.5.3-complete-no-st3.jar org.antlr.Tool myCompiler.g
            javac -cp antlr-3.5.3-complete-no-st3.jar:. *.java
            java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test testing_programs/sample1.c > result/sample1.ll
            java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test testing_programs/sample2.c > result/sample2.ll
            java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test testing_programs/sample3.c > result/sample3.ll
        刪除編譯執行中產生的不必要的資料：
            rm -f *.tokens
            rm -f *.class
            rm -f *.ll
            rm myCompilerLexer.java
            rm myCompilerParser.java