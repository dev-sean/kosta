#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define I 1.0e5
#define T 1.0e7
#define dt 0.001
#define D 1
#define k_1 1
#define k_2 1

double GaussianNumber(void)
{
	static double V1, V2, S;
	static int phase =0;
	double X;

	if(phase==0)
	{
		do
		{
			V1=((double)rand()*2/RAND_MAX-1);
			V2=((double)rand()*2/RAND_MAX-1);
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
			V1=((double)rand()*2/RAND_MAX-1);
			V2=((double)rand()*2/RAND_MAX-1);
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
			V1=((double)rand()*2/RAND_MAX-1);
			V2=((double)rand()*2/RAND_MAX-1);
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
			V1=((double)rand()*2/RAND_MAX-1);
			V2=((double)rand()*2/RAND_MAX-1);
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
			V1=((double)rand()*2/RAND_MAX-1);
			V2=((double)rand()*2/RAND_MAX-1);
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
			V1=((double)rand()*2/RAND_MAX-1);
			V2=((double)rand()*2/RAND_MAX-1);
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

double x[10000000];
double y[10000000];
double v_x[10000000];
double v_y[10000000];
double arr[10000000];
double arr1[10000000];
double arr2[10000000];
double arr3[10000000];
double arr4[10000000];


int main()
{
	FILE *Save1=fopen("C:\\c\\NCW_dis_w.txt","wt");
	FILE *Save2=fopen("C:\\c\\NCW_rms(w)-t.txt","wt");
	FILE *Save3=fopen("C:\\c\\NCW_w-t.txt","wt");
	FILE *Save4=fopen("C:\\c\\NCW_dis_-w.txt","wt");
	FILE *Save5=fopen("C:\\c\\NCW_dis_w_dis_-w.txt","wt");

	int t,i,j;
	double alpha,beta,X,Y,V_x,V_y,dw,W,w=0;
	double edge, lim, L, delta,A=0,sum;

	alpha=1.0;
	beta=-1.0;
	sum=0;
	srand(time(NELL));

	edge = 30;//edge is range the x-axis
	delta=0.01;
	lim = 2*edge/delta;
	L=edge;

	x[0]=GaussianNumber2();
	y[0]=GaussianNumber3();
	v_x[0]=GaussianNumber4();
	v_y[0]=GaussianNumber5();
	
	/***************  calculation  ****************/

	for(i=0; i<I; i++)
	{
		dw=0;
		W=0;
		for(t=1; t<= T; t++)
		{
		
			x[t+1]=x[t]+v_x[t]*dt;
			y[t+1]=y[t]+v_y[t]*dt;
		
			v_x[t+1]=v_x[t]-v_x[t]*dt-(k_1*x[t]+alpha*y[t])*dt+sqrt(2*D*dt)*GaussianNumber();
			v_y[t+1]=v_y[t]-v_y[t]*dt-(k_2*y[t]+beta*x[t])*dt+sqrt(2*D*dt)*GaussianNumber1();

			V_x=(v_x[t+1]+v_x[t])/2;
			V_y=(v_y[t+1]+v_y[t])/2;
			X=(x[t+1]+x[t])/2;
			Y=(y[t+1]+y[t])/2;

			dw=-(beta*X*V_y+alpha*Y*V_x)*dt;
			W+=dw;
			arr[t]+=W/(t*dt);
			
			/****************  w-t at 30th  ******************/
			if(i==30)
			fprintf(Save3,"%lf	%lf\n",t*dt,W/(t*dt));
					
		}
		arr1[i]+=W/(t*dt);
		arr3[i]+=-W/(t*dt);
		sum+=W/(t*dt);
		printf("%d	%lf\n",i,W/(t*dt));

	}

	/*******************  average of w-t  ********************/

	for(t=0; t<T; t++)
	{ 
		
			A+=arr[t];
		
		fprintf(Save2,"%lf	%lf\n", t*dt,A/I);
		A=0;
	}

	/***************  distribution of w  *******************/

	for(i=0; i<I; i++)
	{
		for(j=0; j<lim; j++)
		{
			if(arr1[i]>L)
			{
				arr2[j]++;
				break;
			}
			else
			{
				L-=delta;
			}
		}
		L=edge;

		printf("%d\n", i);
	}

	for(j=0; j<lim; j++)
	{
		fprintf(Save1,"%lf	%lf\n",(edge)-(j)*delta,arr2[j]/(I*delta));
	}
	
	/****************  distribution of -w  *******************/
	
	for(i=0; i<I; i++)
	{
		for(j=0; j<lim; j++)
		{
			if(arr3[i]>L)
			{
				arr4[j]++;
				break;
			}
			else
			{
				L-=delta;
			}
		}
		L=edge;

		printf("%d\n", i);
	}

	for(j=0; j<lim; j++)
	{
		fprintf(Save4,"%lf	%lf\n",(edge)-(j)*delta,arr4[j]/(I*delta));
	}
	
	/*******************  f(w)=w  ***********************/
	
	for(i=0; i<I; i++)
	{
		w=-(log((arr2[i]/(delta*I))/(arr4[i]/(delta*I))))/(T*dt);
		printf("%d	%lf	%lf\n", i, arr2[i]/arr4[i], w);
		if(arr4[i]!=0 && arr2[i]!=0)
		fprintf(Save5,"%lf	%lf\n",-edge+i*delta,w);
	}
	
	return 0;
}
