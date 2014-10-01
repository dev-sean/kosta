#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <time.h>
#include <stdlib.h>

#define N_T	100000//Total Number

double GaussianNumber(void);

double count[1000][1000];

void main()
{
	FILE *C=fopen("C:\\c\\gaussian2De\.txt","wt");
	int n, x_axis, y_axis;
	double X_N, Y_N; //x,y randum number
	double x_edge=5, y_edge=5;
	double L_x, L_y;
	double dt=0.1;	//delta
	double x_w=(2*x_edge/dt), y_w=(2*y_edge/dt); //window수
	int T=0;

	L_x=x_edge;
	L_y=y_edge;

	srand(GetTickCount());

	for (n= 0; n < N_T; n++)
    {
        
		X_N=GaussianNumber(); 
		Y_N=GaussianNumber(); 
		printf("  %d번남음 \n", N_T-n);
		//printf("%0.2lf%%\n", n/N_T*100);
		for(x_axis=0; x_axis<x_w; x_axis++)   
		{
			for(y_axis=0; y_axis<y_w; y_axis++)
			{
				if((Y_N>L_y)&&(X_N>L_x))
				{
					count[x_axis][y_axis]++;
					goto out;
				}
				else
				L_y-=dt;
			}
			
			L_x-=dt;
			L_y=y_edge;
		}
		out:
		L_x=x_edge;
		L_y=y_edge;
		//printf("%d번 남음\n",);
	}
	
	for(x_axis=0; x_axis<x_w; x_axis++)
	{
		for(y_axis=0; y_axis<y_w; y_axis++)
		{
		//fprintf(C,"%lf		%lf		%lf \n", -x_edge+x_axis*dt, -y_edge+y_axis*dt, count[x_axis][y_axis]/(N_T*dt*dt));	
			T+=count[x_axis][y_axis];
		}
	}
	printf("총 시행횟수= %d 카운트 수= %d \n", N_T,T);
 }


double GaussianNumber(void)
{
	static double V1, V2, S;
	static int phase =0;
	double X;

	if(phase==0)
	{
		do
		{
			V1=((double)rand()/RAND_MAX)*2-1;
			V2=((double)rand()/RAND_MAX)*2-1;
			S=V1*V1+V2*V2;
		}
		while(S>=1 || S==0);
			X=V1*sqrt(-2*log(S)/S);
	}
	else
		X=V2*sqrt(-2*log(S)/S);
	phase = 1-phase;
	return X;
}