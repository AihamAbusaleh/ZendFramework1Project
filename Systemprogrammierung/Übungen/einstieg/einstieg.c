/*
*	einstieg.c
*
*	Das erste C-Programm
*
*	Autor : Ich
*	Erstellt am : 20.03.15
*
*/

#include <stdio.h>

int main()
{
    int anzahl;
    char vorname[18];

    printf("Anzahl bisher geschriebene c-progamm eingeben: ");
    scanf("%d" , &anzahl);
    printf("Vorname eingeben : "


          );
    scanf("%s" , vorname);
    printf("%ss %d. C-Programm funktioniert\n" , vorname, anzahl +1);

    return 0                    ;









}
