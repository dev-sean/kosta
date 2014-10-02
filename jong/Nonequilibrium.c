#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <time.h>
#include <stdlib.h>

#define Kb_T 1.0
#define dt 1e-3
#define T 1.0e6	//Total Time

double V_X[100][100][10000];
double V_Y[100][100][10000];
double C[1000][1000];

double GaussianNumber(void);

int main(void)
{
	FILE *Save1=fopen("c:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\CU.txt","wt");
	
	int t,X,Y,result=0,A;
	float delta,lim,x_axis,y_axis,edge;
	double gamma , Noise , k_x , k_y;
	double B, x , y , v_x , v_y , dx , dy , dv_x , dv_y;

	srand(GetTickCount());

	gamma = 0.1, k_x=1 , k_y=1;
	B= 0.1, x=1.0 , y=0.0 , v_x=GaussianNumber(), v_y=GaussianNumber();	// Magnetic field

	edge = 3;	//edge is range the x-axis and y-axis
	delta=0.1;
	lim = 2*edge/(delta);
	x_axis=edge;
	y_axis=edge;

	for(t=0,A=0 ; t<T ; t++)
	{	
		Noise=GaussianNumber();
		dx = v_x * dt , dy = v_y * dt;
		dv_x = (-k_x * x * dt) + (B * v_y * dt) - (gamma * v_x * dt) + (Noise*sqrt(2*gamma*Kb_T*dt));
		dv_y = (-k_y * y * dt) - (B * v_x * dt) - (gamma * v_y * dt) + (Noise*sqrt(2*gamma*Kb_T*dt));
		
		for(X=0, x_axis=edge ; X < lim ; X++, x_axis -=delta)	// Counting
		{	
			for(Y=0, y_axis=edge ; Y < lim ; Y++, y_axis -=delta)
			{
				if( ( (x >= x_axis - delta/2) && ( x <= x_axis + delta/2) )  && (( y >= y_axis - delta/2 ) && ( y <= + y_axis + delta/2) ))	
				{
					ing:;
					
					if(V_X[X][Y][A] == 0)
					{	V_X[X][Y][A]+=v_x; V_Y[X][Y][A]+=v_y; C[X][Y]++;}
					else
					{	A++; goto ing;}
					
					goto finish;
					
				}
			}
		}
		
		if( (X && Y) == lim ) 
		{
			V_X[X][Y][A]+=v_x; V_Y[X][Y][A]+=v_y;  C[X][Y]++;
		}
		finish:;
		
		
		x += dx;
		y += dy;		
		v_x += dv_x;
		v_y += dv_y;

	}
	
	
	for(X=0; X<1000 ; X++)
	{
		for(t=0; t<1000 ; t++)
		{ 
			result+=C[X][t];
		}
	}

	printf("%lf",result/T);


	for(X=0; X<1000 ; X++)
	{
		for(t=0; t<1000 ; t++)
		{ 
			if(C[X][t] == 0)
			{
				C[X][t]++;
			}
		}
	}

	for(A=0;A<30;A++)
	{
		X=20,Y=20;
		fprintf(Save1,"%lf\n",V_X[X][Y][A]);
	}
	
	
	return 0;
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



/*	
	for(X=0;X<=lim;X++)
	{
		for(Y=0 ;Y<=lim;Y++)
		{
			fprintf(Save1,"%lf	%lf	%lf	%lf\n",edge-X*delta , edge-Y*delta ,V_X[X][Y]/C[X][Y]*C[X][Y]/(T*delta*delta), V_Y[X][Y]/C[X][Y]*C[X][Y]/(T*delta*delta)); //Print the counting number
		}
	}
*/