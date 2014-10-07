nclude <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdint.h>
#include <sys/time.h>
#include <unistd.h>
#include <math.h>

main(int argc, char **argv)
{
struct timeval time;
int iRandom1, iRandom2;
double dRandom1, dRandom2, dAverage, dStddev;
long int i, liSampleSize;
    
//Incorrect number of parameters
if (argc!=4) 
{
    printf ("Incorrect number of argument\n");
    printf ("Usage : %s SampleSize Average StdDev\n", argv[0]);
    printf ("Example : To have a 1000 samples centered with 1 of std deviation:\n");
    printf ("%s 1000 0 1\n", argv[0]);
    return 1;
}

//parsing the parameters
sscanf (argv[1],"%ld",&liSampleSize);
sscanf (argv[2],"%lf",&dAverage);
sscanf (argv[3],"%lf",&dStddev);


gettimeofday(&time, NULL);
    
//Convert seconds to a unsigned integer to init the seed
srandom((unsigned int) time.tv_usec);


for (i=0; i<liSampleSize;i++)
{
    //generates a number between 0 and 4G
    iRandom1=(random());
    //offset to have unifor ditribution between -2G and +2G
    dRandom1=(double)iRandom1 /2147483647;
    
    //generates a number between 0 and 4G
    iRandom2=(random());
    //offset to have unifor ditribution between -2G and +2G
    dRandom2=(double)iRandom2 /2147483647;
    
    //Output random values. The formula is based on Box-Muller method
    printf("%f \n", dAverage + dStddev * sqrt(-2.0 * log(dRandom1))*cos(6.28318531 * dRandom2));
}
return 0;
}


