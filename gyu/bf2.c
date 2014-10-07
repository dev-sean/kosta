#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <time.h>
#include <stdlib.h>

#define N_T	1.0e4//Total time
#define N 1.0e5//개수
double v_x[1000000], v_y[10000000], x[10000000], y[10000000];
double a_x[1000][1000], a_y[1000][1000];
double count[1000][1000];

	

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
double GaussianNumber1(void)
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
double GaussianNumber2(void)
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
double GaussianNumber3(void)
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
double GaussianNumber4(void)
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
double GaussianNumber5(void)
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
double GaussianNumber6(void)
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

int main()
{
	FILE *C=fopen("C:\\c\\B5.txt","wt");
	FILE *C1=fopen("C:\\c\\B5a.txt","wt");
	int i, j;
	double dt=0.01;
	double k_x=1.0, k_y=1.0;
	double B=1.0;           //b-field
	double K=1.0, T=1.0;
	double D=K*T;
	double gamma=1.0;
	

	int x_axis, y_axis; 
	double L_x, L_y;
	double delta=0.3;	//delta
	double x_edge=5.0, y_edge=5.0;
	double x_w=(2*x_edge/delta), y_w=(2*y_edge/delta); //window수 
	L_x=x_edge;
	L_y=y_edge;
	
	srand(GetTickCount());
	

	

	for(j=0; j<N; j++)
	{
		printf("%d\n",j);
		v_x[j]= GaussianNumber1();
		v_y[j]= GaussianNumber2();
		x[j]= GaussianNumber3();
		y[j]= GaussianNumber4();
		for(i=0; i<N_T; i++)
		{	
	
			v_x[j+1]= v_x[j] + (-k_x*x[i] +B*v_y[i]-v_x[i])*dt + sqrt(2*D*dt)*GaussianNumber5();
			v_y[j+1]= v_y[j] + (-k_y*y[j] -B*v_x[j]-v_y[j])*dt + sqrt(2*D*dt)*GaussianNumber6();
			x[j+1]=x[j]+v_x[j]*dt;
			y[j+1]=y[j]+v_y[j]*dt;
		}
		
		for(x_axis=0; x_axis<x_w; x_axis++)   
		{
			for(y_axis=0; y_axis<y_w; y_axis++)
			{
				if((v_x[j]>L_y)&&(v_y[j]>L_x))
				{
					count[x_axis][y_axis]++;
					a_x[x_axis][y_axis]+=((v_x[j+1]-v_x[j])/dt);
					a_y[x_axis][y_axis]+=((v_y[j+1]-v_y[j])/dt);
					goto out;
				}
				else
				L_y-=delta;
			}
			
			L_x-=delta;
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
	
			
			fprintf(C,"%lf		%lf		%lf \n", -x_edge+x_axis*delta, -y_edge+y_axis*delta, count[x_axis][y_axis]/(N*delta*delta));	
			if(count[x_axis][y_axis]!=0)
			{
			fprintf(C1,"%lf		%lf		%lf		%lf\n", -x_edge+x_axis*delta, -y_edge+y_axis*delta, a_x[x_axis][y_axis]/(N*delta*delta), a_y[x_axis][y_axis]/(N*delta*delta));//평균가속도*이니셜개수*확률분포
		
			}
		}
	}

			


	
	



	return 0;
}


