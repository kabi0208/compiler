void main()
{
    int a = 5, b= 5;
    if(a < 1){
        printf("a < 1\n");
    }
    else if(a < 3){
        printf("a < 3\n");
    }
    else if(a < b){
        printf("a < 5\n");
    }
    else if(a < 7){
        while(a > 0){
            printf("got you!\n");
            a = a - 1;
        }
    }
    else {
        printf("so big\n");
    }

}