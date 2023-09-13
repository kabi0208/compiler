
int main()
{
    int i,j,k;
    for(i = 0; i < 10; i = i + 1){
        for(j = 0; j < 10; j = j + 1){
            if(i == j){
                printf("!! ");
            }
            else{
                printf("%d ", i*j);
            }
        }
        printf("\n");
        if(i == 9){
            k = 10;
            while(k > 0){
                printf("%d ", k);
                k = k - 1;
            }
            printf("\nperfect!\n");
    
        }
    }
    return 0;
}
