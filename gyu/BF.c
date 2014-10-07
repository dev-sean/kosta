#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <time.h>
#include <stdlib.h>

#define N_T	1.0e5//Total Number
#define SITE 1000000



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

void main()
{
	FILE *C=fopen("C:\\c\\BM_V10^5.txt","wt");
	int i, j;
	double dt=0.01;
	double k_x=1, k_y=1;
	double B=1;           //b-field
	double K=1, T=1;
	double D=K*T;
	double gamma=1;
	double v_x[SITE], v_y[SITE], x[SITE], y[SITE];
	
	srand(GetTickCount());
	v_x[0]= GaussianNumber1();
	v_y[0]= GaussianNumber2();
	x[0]= GaussianNumber3();
	y[0]= GaussianNumber4();

	for(i=0; i<N_T; i++)
	{
		x[i+1] = x[i]+ v_x[i]*dt;
		y[i+1] = y[i]+ v_y[i]*dt;
	}
	for(j=0; j<N_T; j++)
	{
		printf("%d\n",j);
		v_x[j+1]= v_x[j] + (-k_x*x[j] +B*v_y[j])*dt + sqrt(2*D*dt)* GaussianNumber5();
		v_y[j+1]= v_y[j] + (-k_y*y[j] +B*v_x[j])*dt + sqrt(2*D*dt)* GaussianNumber6();
	}


	return 0;
}


