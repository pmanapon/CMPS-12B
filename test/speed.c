#include <stdio.h>
#include <math.h>

//function prototype
double d(float u, int time);


int main(){

printf("The programme will create a table showing the distance due\nto free fall of an object within a specified time interval. \n");
printf("==========================================================\n");
//read initial speed
float u;
printf("Enter initial speed (m/s): ");
scanf("%f",&u);

//read final time
int time;
printf("Enter time interval from t=0 \nFinal time: ");
scanf("%d",&time);

int i;
float distance[time+1];
for(i=0;i<=time;i++){
 distance[i] = d(u,i);
}

printf("===================================\n");
printf("|    time (s)    |  distance (m)  | \n");
printf("===================================\n");

for(i=0;i<=time;i++){
printf("|    %5d       |  %10.3f    | \n",i,distance[i]);
}
printf("===================================\n");

  return 0;
}

//function calculate distance
double d(float u, int t){

    float distance=(u*t) + (0.5*9.81*t*t);

 return distance;

}
