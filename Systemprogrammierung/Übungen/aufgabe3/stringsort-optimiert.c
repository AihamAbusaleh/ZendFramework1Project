#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

/*int intcmp(const void , const void );
*/
int main(int argc, char *argv[])
{
	int i,j,n,m;
	char* s;
	char* g;
	char *tmp;
	time_t t; 
	srand((unsigned) time(&t));

	if(argc < 2)
	{
		printf("Aufruf: nicht genuegend Parameter ");
		return EXIT_FAILURE;
	}
	n = atoi(argv[1]);
	m = strlen(argv[1]) + 1;


	  
	printf("\nunsortiertes Feld: \n");
	
	g =  (char *) malloc((m*n+1) * sizeof(char));
	s =  (char *) malloc((m*n) * sizeof(char));
	tmp = (char *) malloc( m * sizeof(char));
	for(i = 0; i < n ; ++i ) 
	{	
	    
		sprintf(&s[i*m],"%d", rand() % n);/*  s+ i*m */
		printf("%s ", &s[i*m]);
	}
	printf("\nSortiertes Feld: \n");


	for (i = n ; i > 1; --i){
		
		for(j = 0; j < i - 1 ; j++){
			if(strcmp(&s[j*m],&s[(j+1)*m]) > 0)
			{
				
				memcpy(tmp, &s[(j + 1)*m], m); 
				memcpy(&s[(j+1)*m], &s[j*m] ,m);
				memcpy(&s[j*m],tmp ,m);
			}
		}

	}


   strcpy(g, &s[0]);
    for(i = 1 ; i < n ; ++i)
    {
        const char *star = "*";
        const char *empty = " ";


        if(strcmp(&s[i*m], &s[(i - 1)*m]) == 0)
        {
            strcat(g, star);
        }
        else
        {
            strcat(g, empty);
            strcat(g, &s[i*m] );
        }


    }
    printf("%s ", g);
    printf("\n ");
	/*int intcmp(const void *p, const void *q){
		const int *left = (const int *) p;
		const int *right = (const int *) q;
		if (*left > *right) return 1;
		if (*left < *right) return -1;
		return 0;
	
	}
*/
	/*was mallociert, feldgroesse, size, sortierfunktion*/
	/*qsort(s,n, sizeof(char), intcmp);
	*/
	free(s);
		free(g);
	free(tmp);
	return EXIT_SUCCESS;
}
