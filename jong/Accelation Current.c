#include <stdio.h>
#include <math.h>
#include <Windows.h>
#include <time.h>
#include <stdlib.h>
#define Delta 0.00001
#define delta 0.1
#define Kb_T 1.0
#define dt 1e-3
#define T 1.0e7	//Total Time
#define I 1.0e1 //Initial Condition

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

struct point_pos
{
	double x_pos;
	double y_pos;
	int p;
	int q;
};

struct point
{
	double x_vel;
	double y_vel;
	int i;
	int j;
};

struct point_acc
{
	double x_acc;
	double y_acc;
	int k;
	int l;
};


struct point_acc accel[1000][1000];
struct point vel[1000][1000];
struct point_pos posi[1000][1000];

int main(void)
{
	FILE *Save1=fopen("C:\\c\\Patial3.txt","wt");
	FILE *Save2=fopen("C:\\c\\Patial4.txt","wt");
	FILE *Save3=fopen("C:\\c\\Patial5.txt","wt");
	/*FILE *Save4=fopen("C:\\c\\Patial4.txt","wt");
	FILE *Save5=fopen("C:\\c\\Patial5.txt","wt");
	FILE *Save6=fopen("C:\\c\\Patial6.txt","wt");
	FILE *Save7=fopen("C:\\c\\Patial7.txt","wt");
	FILE *Save8=fopen("C:\\c\\Patial8.txt","wt");
	FILE *Save9=fopen("C:\\c\\Patial9.txt","wt");
	*/
	int t,v_x_axis, v_y_axis,i,x_axis,y_axis;
	double  gamma , Noise , k_x , k_y, edge_x, edge_y, L_x, L_y, lim_x, lim_y;
	double B1, x1 , y1 , v_x1 , v_y1 , dx1 , dy1 , dv_x1 , dv_y1;
	
			
	edge_x=5.0;
	edge_y=5.0;
	lim_x=2*edge_x/delta;
	lim_y=2*edge_y/delta;
	L_x=edge_x;
	L_y=edge_y;
	
	srand(GetTickCount());

	gamma = 1.0, k_x=1 , k_y=1;
	B1	= 5.0;	// positive Magnetic field
	
	for(i=0 ; i<I ; i++)
	{
		v_x1=GaussianNumber(), v_y1=GaussianNumber1(),x1=GaussianNumber2(),y1=GaussianNumber2();

	for(t=0 ; t<T ; t++ )
	{
		Noise=GaussianNumber();
		dx1 = v_x1 * dt , dy1 = v_y1 * dt;
		dv_x1 = (-k_x * x1 * dt) + (B1 * v_y1 * dt) - (gamma * v_x1 * dt) + (Noise*sqrt(2*gamma*Kb_T*dt));
		dv_y1 = (-k_y * y1 * dt) - (B1 * v_x1 * dt) - (gamma * v_y1 * dt) + (Noise*sqrt(2*gamma*Kb_T*dt));
		
		
			for(v_x_axis=0; v_x_axis<lim_x; v_x_axis++)
			{
				for(v_y_axis=0; v_y_axis<lim_y; v_y_axis++)
				{
					if( (v_x1>L_x) && (v_y1>L_y) )
					{	
						vel[v_x_axis][v_y_axis].x_vel+=v_x1; vel[v_x_axis][v_y_axis].y_vel+=v_y1;
						vel[v_x_axis][v_y_axis].i++; vel[v_x_axis][v_y_axis].j++;
						
						accel[v_x_axis][v_y_axis].x_acc+=(dv_x1/dt);
						accel[v_x_axis][v_y_axis].y_acc+=(dv_y1/dt);
						accel[v_x_axis][v_y_axis].k++;
						accel[v_x_axis][v_y_axis].l++;
					goto A;
					}
					else
					{
					L_y-=delta;
					}
				}

				L_x-=delta;
				L_y=edge_y;
			}
		
A:
		L_x=edge_x;
		L_y=edge_y;
				
			for(x_axis=0; x_axis<lim_x; x_axis++)
			{
				for(y_axis=0; y_axis<lim_y; y_axis++)
				{
					if( (x1>L_x) && (y1>L_y) )
					{	
						posi[x_axis][y_axis].x_pos+=x1; posi[x_axis][y_axis].y_pos+=y1;
						posi[x_axis][y_axis].p++; posi[x_axis][y_axis].q++;
						
						goto B;
					}
					else
					{
					L_y-=delta;
					}
				}

				L_x-=delta;
				L_y=edge_y;
			}
		

B:
				
		x1 += dx1;
		y1 += dy1;		
		v_x1 += dv_x1;
		v_y1 += dv_y1;

		L_x=edge_x;
		L_y=edge_y;

		}
		printf("%d\n",i+1);

	}
			/*for(v_x_axis=0; v_x_axis<lim_x; v_x_axis++)
			{
				for(v_y_axis=0; v_y_axis<lim_y; v_y_axis++)
				{
					if(vel[v_x_axis][v_y_axis].i==0)
						vel[v_x_axis][v_y_axis].i++;
					if(vel[v_x_axis][v_y_axis].j==0)
						vel[v_x_axis][v_y_axis].j++;
				}
			}
			for(x_axis=0; x_axis<lim_x; x_axis++)
			{
				for(y_axis=0; y_axis<lim_y; y_axis++)
				{
					if(posi[x_axis][y_axis].p==0)
						posi[x_axis][y_axis].p++;
					if(posi[x_axis][y_axis].q==0)
						posi[x_axis][y_axis].q++;
				}
			}*/

	
			for(v_x_axis=0; v_x_axis<lim_x; v_x_axis++)
			{
				for(v_y_axis=0; v_y_axis<lim_y; v_y_axis++)
				{
					fprintf(Save1,"%lf	%lf	%lf	%lf\n", -edge_x+delta*v_x_axis, -edge_y+delta*v_y_axis ,vel[v_x_axis][v_y_axis].i/(I*T*delta*delta),vel[v_x_axis][v_y_axis].j/(I*T*delta*delta));
		 			fprintf(Save2,"%lf	%lf	%lf	%lf\n", -edge_x+delta*v_x_axis, -edge_y+delta*v_y_axis ,posi[v_x_axis][v_y_axis].p/(I*T*delta*delta),posi[v_x_axis][v_y_axis].q/(I*T*delta*delta));
					fprintf(Save3,"%lf	%lf	%lf	%lf\n", -edge_x+delta*v_x_axis, -edge_y+delta*v_y_axis ,accel[v_x_axis][v_y_axis].x_acc*vel[v_x_axis][v_y_axis].i/(I*T*delta*delta*I*T*delta*delta),accel[v_x_axis][v_y_axis].y_acc*vel[v_x_axis][v_y_axis].j/(I*T*delta*delta*I*T*delta*delta));
				}
			}

	return 0;
}