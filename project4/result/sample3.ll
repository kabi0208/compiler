; === prologue ====
declare dso_local i32 @printf(i8*, ...)

define dso_local i32 @main()
{
%t0 = alloca i32, align 4
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
store i32 0, i32* %t0
br label %L1
L1:
%t3=load i32, i32* %t0
%cond0 = icmp slt i32 %t3, 10
br i1 %cond0, label %L2, label %L3
L2:
%t4=load i32, i32* %t0
%t5 = add nsw i32 %t4, 1
store i32 0, i32* %t2
br label %L4
L4:
%t6=load i32, i32* %t2
%cond1 = icmp slt i32 %t6, 10
br i1 %cond1, label %L5, label %L6
L5:
%t7=load i32, i32* %t2
%t8 = add nsw i32 %t7, 1
%t9=load i32, i32* %t0
%t10=load i32, i32* %t2
%cond2 = icmp eq i32 %t9, %t10
br i1 %cond2, label %L7, label %L8
L7:
%t11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.0, i64 0, i64 0))
br label %L9
L8:
%t12=load i32, i32* %t0
%t13=load i32, i32* %t2
%t14 = mul nsw i32 %t12, %t13
%t16 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([1 x i8], [1 x i8]* @.str.2, i64 0, i64 0))
%t15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.1, i64 0, i64 0), i32 %t14)
%t17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.3, i64 0, i64 0))
br label %L9
L9:
store i32 %t8, i32* %t2
br label %L4
L6:
%t18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.4, i64 0, i64 0))
%t19=load i32, i32* %t0
%cond3 = icmp eq i32 %t19, 9
br i1 %cond3, label %L10, label %L11
L10:
store i32 10, i32* %t1
br label %L13
L13:
%t20=load i32, i32* %t1
%cond4 = icmp sgt i32 %t20, 0
br i1 %cond4, label %L14, label %L15
L14:
%t21=load i32, i32* %t1
%t23 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([1 x i8], [1 x i8]* @.str.6, i64 0, i64 0))
%t22 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.5, i64 0, i64 0), i32 %t21)
%t24 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.7, i64 0, i64 0))
%t25=load i32, i32* %t1
%t26 = sub nsw i32 %t25, 1
store i32 %t26, i32* %t1
br label %L13
L15:
%t27 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([11 x i8], [11 x i8]* @.str.8, i64 0, i64 0))
br label %L12
L11:
br label %L12
L12:
store i32 %t5, i32* %t0
br label %L1
L3:
ret i32 0

; === epilogue ===
ret i32 0
}
@.str.0 = private unnamed_addr constant [4 x i8] c"!! \00", align 1
@.str.1 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.2 = private unnamed_addr constant [1 x i8] c"\00", align 1
@.str.3 = private unnamed_addr constant [2 x i8] c" \00", align 1
@.str.4 = private unnamed_addr constant [2 x i8] c"\0A\00", align 1
@.str.5 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.6 = private unnamed_addr constant [1 x i8] c"\00", align 1
@.str.7 = private unnamed_addr constant [2 x i8] c" \00", align 1
@.str.8 = private unnamed_addr constant [11 x i8] c"\0Aperfect!\0A\00", align 1
