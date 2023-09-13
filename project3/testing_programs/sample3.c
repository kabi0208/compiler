#include <stdio.h>

int main(){
    int n,m,i,j,x,y;
    char a[110][110]={'\0'};
    scanf("%d%d",&n,&m);
    for(i=0;i<n;i++){
        scanf("%s",a[i]);
    }
    int hurt=0,maxhurt=0;
    int bb,k;
    scanf("%d",&bb);
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            hurt=0;
            if(a[i][j]!='.'){
                continue;
            }
            for(k=1;k<bb+1;k++){
                if(j-k<0||a[i][j-k]==NULL){
                    break;
                }
                else if(a[i][j-k]=='@'){
                    hurt++;
                }
            }
            for(k=1;k<bb+1;k++){
                if(j+k>m-1||a[i][j+k]=='#'){
                    break;
                }
                else if(a[i][j+k]=='@'){
                    hurt++;
                }
            }
            for(k=1;k<bb+1;k++){
                if(i-k<0||a[i-k][j]=='#'){
                    break;
                }
                else if(a[i-k][j]=='@'){
                    hurt++;
                }
            }
            for(k=1;k<bb+1;k++){
                if(i+k>n-1||a[i+k][j]=='#'){
                    break;
                }
                else if(a[i+k][j]=='@'){
                    hurt++;
                }
            }
            if(hurt>maxhurt){
                maxhurt=hurt;
                x=i;
                y=j;
            }
        }
    }
    printf("%d %d\n",x,y);
    printf("%d",maxhurt);
    return 0;
}
