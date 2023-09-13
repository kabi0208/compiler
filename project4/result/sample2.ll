; === prologue ====
declare dso_local i32 @printf(i8*, ...)

define dso_local i32 @main()
{
%t0 = alloca i32, align 4
store i32 5, i32* %t0
%t1 = alloca i32, align 4
store i32 5, i32* %t1
%t2=load i32, i32* %t0
%cond0 = icmp slt i32 %t2, 1
br i1 %cond0, label %L1, label %L2
L1:
%t3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str.0, i64 0, i64 0))
br label %L3
L2:
%t4=load i32, i32* %t0
%cond1 = icmp slt i32 %t4, 3
br i1 %cond1, label %L4, label %L5
L4:
%t5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str.1, i64 0, i64 0))
br label %L3
L5:
%t6=load i32, i32* %t0
%t7=load i32, i32* %t1
%cond2 = icmp slt i32 %t6, %t7
br i1 %cond2, label %L6, label %L7
L6:
%t8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str.2, i64 0, i64 0))
br label %L3
L7:
%t9=load i32, i32* %t0
%cond3 = icmp slt i32 %t9, 7
br i1 %cond3, label %L8, label %L9
L8:
br label %L10
L10:
%t10=load i32, i32* %t0
%cond4 = icmp sgt i32 %t10, 0
br i1 %cond4, label %L11, label %L12
L11:
%t11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([10 x i8], [10 x i8]* @.str.3, i64 0, i64 0))
%t12=load i32, i32* %t0
%t13 = sub nsw i32 %t12, 1
store i32 %t13, i32* %t0
br label %L10
L12:
br label %L3
L9:
%t14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @.str.4, i64 0, i64 0))
br label %L3
L3:

; === epilogue ===
ret i32 0
}
@.str.0 = private unnamed_addr constant [7 x i8] c"a < 1\0A\00", align 1
@.str.1 = private unnamed_addr constant [7 x i8] c"a < 3\0A\00", align 1
@.str.2 = private unnamed_addr constant [7 x i8] c"a < 5\0A\00", align 1
@.str.3 = private unnamed_addr constant [10 x i8] c"got you!\0A\00", align 1
@.str.4 = private unnamed_addr constant [8 x i8] c"so big\0A\00", align 1
