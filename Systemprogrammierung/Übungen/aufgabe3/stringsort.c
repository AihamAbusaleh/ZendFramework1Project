#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

int main(int argc, char *argv[])
{
    int i, j, n, m;
    char  **b;
    char *s;
    
    time_t t;
    srand((unsigned) time(&t));

    if(argc < 2)
    {
        printf("Aufruf: nicht genuegend Parameter ");
        return EXIT_FAILURE;
    }
    n = atoi(argv[1]);
    m = strlen(argv[1]) +1;
    b = (char **) malloc(n * sizeof(char *)); /* reserviere  b** */
    s = (char *) malloc(n*m+1 * sizeof(char));
    printf("\nunsortiertes Feld: \n");

    for(i = 0; i < n ; ++i )
    {
        /* reserviere b* also Zeichen*/
        b[i] =  (char *) malloc((n + 1) * sizeof(char));
        sprintf(b[i], "%d", rand() % 10);
        printf("%s ", b[i]);
    }

    for(i = n; i > 1 ; --i )
    {
        for(j = 0; j < i - 1; ++j)
        {

            if(strcmp(b[j], b[j + 1]) > 0 ) /* vorgänger groesser nachgänge*/
            {
                char*  tmp =  b[j + 1];
                b[j + 1] = b[j];
                b[j] = tmp;
            }

        }

    }
    printf("\nSortiertes Feld: \n");
    strcat(s, b[0] );
    for(i = 1 ; i < n ; ++i)
    {
        const char *star = "*";
        const char *empty = " ";


        if(strcmp(b[i], b[i - 1]) == 0)
        {
            strcat(s, star);
        }
        else
        {
            strcat(s, empty);
            strcat(s, b[i] );
        }


    }
    printf("%s ", s);

 

    for (i = 0; i < n; ++i)
    {
        free(b[i]);
    }
    free(b);
    return EXIT_SUCCESS;
}
