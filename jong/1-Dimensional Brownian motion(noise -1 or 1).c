#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <stdlib.h>
#define PI 3.141592654
#define dt 0.01
#define D 1.0
#define num1 1000000
double a[100000];

double RandomNumber(void) //랜덤함수
{
	double x;
	x =  ((double) rand() / RAND_MAX * 2 - 1);      // -1.0 ~ 1.0 까지의 실수 값
	return x;
}

int main(void)
{ 
	FILE *fx=fopen("C:\\Users\\Theory\\Desktop\\Noise(1 or -1).txt", "wt");
	
	int i,E,j;
	double v,p_x,dx=0,edge,delta,L,lim; //edge 가장자리값
	srand(GetTickCount());
	
	v=RandomNumber(); // 초기값 정의
		
	edge=4;
	delta=0.01;
	lim=2*edge/delta;
	L=edge;
	
	
	for( i=0; i<=num1; i++ )
	{	
		if(RandomNumber() > 0) //랜덤넘버 크사이 1 또는 -1 로 정의
		{
			E=1;
			v=v-v*dt+sqrt(2*D*dt)*E; 
			//p_x=sqrt(1/(D*2*PI))/exp(v*v/(2*D));

		}
		else
		{
			E=-1;
			v=v-v*dt+sqrt(2*D*dt)*E; 
			//p_x=sqrt(1/(D*2*PI))/exp(v*v/(2*D));

		}
			
		for(j=1;j<=lim;j++)
		{	
			if(v>L) 
			{
				a[j]+=1;
				break;
			}
			else 
			{
				L-=delta;
			}
		}
					
		L=edge;
		printf("%d번째 남음\n",num1-i);
	}
	
	
	for(j=0 ;j<=lim ;j++)
	{
		fprintf(fx,"%lf		%10lf\n",edge-j*delta, a[j]/(num1*delta));	
	}
	
	fclose(fx);

	return 0;

}



