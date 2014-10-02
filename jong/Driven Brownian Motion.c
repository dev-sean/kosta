#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <time.h>
#include <stdlib.h>

#define dt 1.0e-3
#define gamma 1.0
#define Kb_T 1.0	// Boltzmann constant and Temperature
#define T 5e3	
#define N_T 5.0e3	// Total Number

#define edge_x_p 4
#define edge_q 3
#define delta_x_p 0.25
#define delta_q 0.05
#define k 1.0

double c[5000][2000];
double A[5001][2000];
double GaussianNumber(void);

int main(void)
{

	//	FILE *F0=fopen("C:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\B0.0.txt", "wt");	FILE *F1=fopen("C:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\B0.5.txt", "wt");	FILE *F2=fopen("C:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\B1.0.txt", "wt");	FILE *F3=fopen("C:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\B2.0.txt", "wt");  	FILE *F4=fopen("C:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\B3.0.txt", "wt");	FILE *F5=fopen("C:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\B4.0.txt", "wt");

	FILE *C=fopen("C:\\Users\\Benny\\Desktop\\대학\\연구실관련\\Data\\Bcounting.txt", "wt");
	
	int i,t,Q,X,P;
	double q, dq, p, dp, x, dx, N_windwos_x_p, N_windwos_q, x_axis, p_axis, q_axis, Noise ;		
	srand(GetTickCount());			
	N_windwos_x_p = edge_x_p/delta_x_p ;
	N_windwos_q = edge_q/delta_q ;
	
	for(i=0; i<N_T; i++)
	{
		Noise=GaussianNumber();
		p = GaussianNumber();	x=0.0;  p=0.0; q=0.0;
			
		for(t=0; t<T; t++)
		{	
			dp = - (p + k * x) * dt + Noise * sqrt(2*Kb_T*dt);	
			dx = p * dt;
			dq = (-gamma * p * dt + Noise * sqrt(2*Kb_T*dt)) * ((p + p + dp)/2);

			for(x_axis = -edge_x_p, X=1000 - N_windwos_x_p ; x_axis <= edge_x_p ; x_axis += delta_x_p, X++, p_axis = edge_x_p)	// Counting
			{	
				for(p_axis = -edge_x_p, P=1000 - N_windwos_x_p ; p_axis <= edge_x_p ; p_axis += delta_x_p, P++)
				{
					if( ( (x >= x_axis - delta_x_p/2) && ( x <= x_axis + delta_x_p/2) )  && (( p >= p_axis - delta_x_p/2 ) && ( p <= + p_axis + delta_x_p/2) ))	
					{
						c[X][P]++;
						goto finish;
					}
				}
			}
			if( (x_axis == edge_x_p) && (p_axis == edge_x_p) ) c[X][P]++;
			finish:;

			for(q_axis = -edge_q, Q=1000-N_windwos_q ; q_axis <= edge_q ; q_axis += delta_q, Q++)
			{
				if( (q >= q_axis - delta_q/2) && (q <= q_axis + delta_q/2) ) { A[t][Q]++; break; }
			}

			q += dq;
			p += dp;
			x += dx;
			Noise=GaussianNumber();

		}

	}

	for(x_axis = - edge_x_p, X = 1000 - N_windwos_x_p ; x_axis <= edge_x_p+delta_x_p ; x_axis += delta_x_p, X++)
	{
		for(p_axis = - edge_x_p, P = 1000 - N_windwos_x_p ; p_axis <= edge_x_p + delta_x_p ; p_axis += delta_x_p, P++)
		{
			fprintf(C,"%5.2lf	%5.2lf	%lf\n", x_axis , p_axis, c[X][P]/ ( N_T * T * delta_x_p * delta_x_p) ); //Print the counting number
		}
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
