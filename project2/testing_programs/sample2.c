#include <stdio.h>

int table[1024][100020];

int main(){
    int t1,t2,i,n,max,last;
    scanf("%d%d",&n,&max);
    int w[n+2];
    int v[n+2];
    for(i=1;i<=n;i++){
        scanf("%d%d",&w[i],&v[i]);
    }
    for(i=0;i<max;i++){
        table[0][i]=0;
    }
    for(i=1;i<=n;i++){
        for(int j=1;j<=max;j++){
            if(j<w[i]){
                table[i][j]=table[i-1][j];
            }
            else{
                last=j-w[i];
                t1=v[i]+table[i-1][last];
                t2=table[i-1][j];
                if(t1>t2){
                    table[i][j]=t1;
                }
                else{
                    table[i][j]=t2;
                }
            }
        }
    }
    printf("%d\n",table[n][max]);
    return 0;
}
