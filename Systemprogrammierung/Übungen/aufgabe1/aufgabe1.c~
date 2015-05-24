/**
*		Aufgabe 1 Abgabe bis 9.4.15
*      @Autor : Aiham Abusaleh
*
*/

#include<stdio.h>
#include<stddef.h>


int main (void)
{
    int a = 54321; 
    short b  = -5873;
    long  c = 56789098L; 
    unsigned d = 12345;
    unsigned short e = 127;
    unsigned long f = 76544L;
    float g = 15.44F;
    double h = 145.50;
    long double i = 134.56433L;
    char j = 'm';
    signed char k = -1;
    unsigned	char l =  122;
    const char* s = "Hallo";
    size_t  t1 = sizeof (int) ;
	size_t  t2 = sizeof (long) ;
	size_t  t3 = sizeof (char*) ;

    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = int; (Variablenname) = a; (Wert) = %d \n\n", (void*) &a, (unsigned long) sizeof a, a );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = short;(Variablenname) = b; (Wert) = %d \n\n", (void*) &b, (unsigned long) sizeof b, b );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = long;(Variablenname) = c;  (Wert) = %ld \n\n", (void*) &c, (unsigned long) sizeof c, c );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = unsigned;(Variablenname) = d;  (Wert) = %d \n\n", (void*) &d, (unsigned long) sizeof d, d );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = unsigned short;(Variablenname) = e;  (Wert) = %d \n\n", (void*) &e, (unsigned long) sizeof e, e);
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = unsigned long;(Variablenname) = f;  (Wert) = %lu \n\n", (void*) &f, (unsigned long) sizeof f, f );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = flot;(Variablenname) = g;  (Wert) = %f \n\n", (void*) &g, (unsigned long) sizeof g, g );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = double;(Variablenname) = h;  (Wert) = %5f \n\n", (void*) &h, (unsigned long) sizeof h, h );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = long double;(Variablenname) = i;  (Wert) = %Lf \n\n", (void*) &i, (unsigned long) sizeof i, i );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = char; (Variablenname) = j; (Wert) = %c \n\n", (void*) &j, (unsigned long) sizeof j, j );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = signed char;(Variablenname) = k;  (Wert) = %d \n\n", (void*) &k, (unsigned long) sizeof k, k );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = unsigned char;(Variablenname) = l;  (Wert) = %u \n\n", (void*) &l, (unsigned long) sizeof l, l );
    printf(" (Adresse) = %p ;  (Platzbedarf) = %lu ;(Type) = char;(Variablenname) = s;  (Wert) = %s \n\n", (void*) &s, (unsigned long) sizeof s, s );
	
	if(t1 == (size_t) 4 ||t2 == (size_t) 8 ||t3== (size_t) 8 ) 
	{
		printf("C-Datenmodell ist  \"LP64\" \n");
	}
	else if(t1 == (size_t) 4 ||t2 == (size_t) 4 ||t3== (size_t) 4 )
	{	
		printf("C-Datenmodell ist  LP32 \n");
		
	}
	else 
	{	
		printf("unbekanntes C-Datenmodell\n ");
	}
    return 0;
}
