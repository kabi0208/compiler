# include <stdio.h>
# define max 10

int add(int a, int b){
    return a + b;
}

int main(){
    unsigned int i, j = 0;
    scanf("%d", &i);
    while(i--, i > 0){
        switch (j)
        {
        case 0:printf("%d\n", i + max);
            /* code */
            break;
        case 1:printf("%d\n", add(i, 6));
        default:
            break;
        }
    }
    return 0;
}
