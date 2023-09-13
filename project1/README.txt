Project 1: lexical analyzer
409410024 資工三 陳品希

注意事項：
    1. 需先安裝"antlr-3.5.3-complete-no-st3.jar"，並置於當前資料夾
        若要用其他ANTLR的話，需為v3，並修改makefile中的名稱
    2. 3個test program皆放在test program資料夾內，按順序檔名分別為'sample1.c'~'sample3.c'
    3. 程式需在Linux或Unix-like環境下執行，需有java的compiler，需有openjdk

如何編譯執行：
    1. 在Terminal 移動到當前資料夾位置後，輸入 'make'即可，輸出結果可直接於Terminal看，
        也有輸出到test program資料夾中，按順序檔名分別為'output1.txt'~'output3.txt'
    2. 輸入make clean可清除編譯執行中除output之外的所有檔案
    3. makefile講解:
        編譯：
            java -jar antlr-3.5.3-complete-no-st3.jar  mylexter.g
            javac -cp ./antlr-3.5.3-complete-no-st3.jar  testLexer.java mylexter.java
        執行：
            output到txt檔：
                java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample1.c > testing_programs/output1.txt
                java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample2.c > testing_programs/output2.txt
                java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample3.c > testing_programs/output3.txt
            output到Terminal：
                java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample1.c
                java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample2.c
                java -cp ./antlr-3.5.3-complete-no-st3.jar:. testLexer testing_programs/sample3.c
        刪除編譯執行中產生的不必要的資料：
            rm -f *.tokens
            rm -f *.class
            rm mylexter.java