#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
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

int main()
{
	int i=0;
	while(1)
	{
		i++;
		printf("%4lf	", (double)i/1000000);
		printf("%lf\n", GaussianNumber());
	}
	return 0;
}

