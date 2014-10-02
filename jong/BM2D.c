#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <time.h>
#include <stdlib.h>

#define N_T	1.0e7//Total Number
#define SITE 1000000

double GaussianNumber(void);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
double count_x[SITE];
double count_y[SITE];
double count[10000][10000];



void main()
{
	FILE *C=fopen("C:\\c\\BM2D-10^7.txt","wt");
	int i, j; //시행하는 번째
	int x_axis, y_axis;  
	double X_N, Y_N; //x,y randum number
	double v_x0=0, v_y0=0;
	double v_x=0, v_y=0;
	double L_x, L_y; //x,y edge
	double dt=0.1;	//delta
	double x_edge=5, y_edge=5;
	double x_w=(2*x_edge/dt), y_w=(2*y_edge/dt); //window수 
	double K=1, T=1;
	double D=K*T;
	double m=1;  //질량
	double a=0;  //가속도
	double gamma=1; //감마
	double S, S_x, S_y; //노이즈
		//m v닷=감마v+노이즈                 v닷=감마/m *v +노이즈          v_x= v_x_1 - v_x_1*deta T  +sqrt(2*D*deltaT)*랜덤
	L_x=x_edge;
	L_y=y_edge;
	srand(GetTickCount());

	
	
	
		//printf("%d		%f \n", i, count[i]);
		//fprintf(C,"%f\n",  count[i]);
		//v_x = v_x0 + (n * (-v_x*dt) + sqrt(2*D*dt) ); 
		//v_x += vx - v_x*dt + + sqrt(2 * D * dt) * S ;
		//a= gamma / m * v_x + S;
		
		//fprintf(C,"%d		%f\n", i, count[i]); */


	for(i=1; i<=N_T; i++)
	{
		S_x= GaussianNumber();
		S_y= GaussianNumber();	
		//printf("%d번째 \n", i);
		v_x = v_x + (-v_x*dt) + (sqrt(2*D*dt)*S_x);
		v_y = v_y + (-v_y*dt) + (sqrt(2*D*dt)*S_y);
		//count_x[i] = count_x[i-1] + (-count_x[i-1] + count_x[i-1]*dt + sqrt(2 * D * dt) * S_x);
		//count_y[i] = count_y[i-1] + (-count_y[i-1] + count_y[i-1]*dt + sqrt(2 * D * dt) * S_y);
		printf("%d	%lf	%lf \n", i, v_x, v_y);
		
		for(x_axis=0; x_axis<x_w; x_axis++)   
		{
			for(y_axis=0; y_axis<y_w; y_axis++)
			{
				if((v_x>L_y)&&(v_y>L_x))
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
		
	}
	for(x_axis=0; x_axis<x_w; x_axis++)
	{
		for(y_axis=0; y_axis<y_w; y_axis++)
		{
			
			fprintf(C,"%lf		%lf		%lf \n", -x_edge+x_axis*dt, -y_edge+y_axis*dt, count[x_axis][y_axis]/(N_T*dt*dt));	
			//][y_axT+=count[x_axisis];
		}
	}
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