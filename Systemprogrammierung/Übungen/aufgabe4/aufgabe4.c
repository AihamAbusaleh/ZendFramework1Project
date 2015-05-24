/*
 * aufgabe4.c
 * Liest Fachnamen mit Beurteilung ein und gibt dann einen Notenspiegel aus.
 * Autor: Abusaleh
 * Erstellt am: 10.05.15
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

enum p_arten {BENOTET, UNBENOTET};

struct strukturen
{
	struct strukturen *vor;
	struct strukturen *nach;
	char fachname[20];
	enum p_arten art;
	union
	{
		int note;
		char beurteilung;   /* 'B' oder 'N' */
	}u;
};
typedef struct strukturen fach_note;

int einlesen(fach_note *n);
void ausgeben(const fach_note *n);
fach_note *einfuegen(fach_note *head, fach_note *neues, fach_note **altes);
fach_note *entfernen(fach_note *head, fach_note **aktuell);
void schleife(fach_note *l, void (*ausgeben)(const fach_note *n));

int main(void)
{
	fach_note *notenspiegel = NULL;
	fach_note *p;
	fach_note *q;

	/*------------------------------------------- Notenspiegel einlesen */
	fprintf(stderr, "Faecher mit Noten eingeben (Ende mit Strg-D):\n");

	for (;;)
	{
		p = (fach_note *) malloc(sizeof (fach_note));
		if (p == NULL) /* Datei aufgabe4-in.tt für den automatisierten Test entnehmen */
		{
			fprintf(stderr, "Zu viele Faecher!\nc");
			break;
		}

		if (! einlesen(p))
		{
			fprintf(stderr, "Eingabeende!\n");
			free(p);
			break;
		}

		notenspiegel = einfuegen(notenspiegel, p, &q);
		if (q != NULL)
		{
			fprintf(stderr, "Alte Eingabe ueberschrieben!\n");
			free(q);
		}
	}

	/*------------------------------------------- Notenspiegel ausgeben */
	printf("Notenspiegel:\n");

	schleife(notenspiegel, ausgeben);

	/*------------------------------------------- Notenspiegel loeschen */
	while (notenspiegel != NULL)
	{
		notenspiegel = entfernen(notenspiegel, &p);
		free(p);
	}

	return 0;
}


int einlesen(fach_note *n)   /*kann auch int* sein  ? */
{
	const char leer = ' ';
	char *pos ; 

	
		if (scanf("%s %d",n->fachname, &n->u.note)) 		/* oder (*n).fachname  */
		{

		} 
		else 
		{	 	
			scanf("%s %c",n->fachname, &n->u.beurteilung);  	/* Beurteilung ist B oder N*/
		
		}	
		for( pos = 0; pos < n->fachname; pos++)
		{
			pos = strchr(n->fachname, '_'); /*ab dem Zeichen; also alles davor ist weg */
			pos[0] = leer;
			return 0;	
		}
			
		return -1;
}


void ausgeben(const fach_note *n)
{
	/*n = (fach_note *) malloc(sizeof(fach_note));
*/
	if (n->art == BENOTET)
	{
		switch(n->u.note)
		{
		case 10: case 13: case 17: case 20: case 23: case 27: case 30: case 33: case 37: case 40: case 50:
			printf("%d" ,(n->u.note / 10)); 
			break;
		default : 
			printf("Fehler : %d", n->u.note );
			break;
		}
	} 
	else 
	{	
		switch(n->u.beurteilung)
		{
		case 'B':
			printf("%c bestanden" ,n->u.beurteilung); 
			break;
		case 'N':	
			printf("%c nicht bestanden" ,n->u.beurteilung); 
			break;	
		}
	}	
	
}


fach_note *einfuegen(fach_note *head, fach_note *neues, fach_note **altes)
{
	fach_note *p;
	*altes = NULL;
	while(p != NULL)
	{
			head->vor = neues;
			neues->nach = head;
			neues->vor = NULL;  /*oder auf neues ?!!! */
			
			if (strcmp(p->fachname,  neues->fachname) == 0  )  /* vergleiche noch PrüfungsART*/
			{
				if(p->nach != NULL)
				{
					p->nach->vor = p->vor;
					p->vor->nach = p->nach;

					*altes = *altes;
				} else 
				{
					p->vor->nach = NULL;
					
				}
				 *altes = p;
			}
		p = p->nach;	
		
	}
	return neues;

}


fach_note *entfernen(fach_note *head, fach_note **del)
{
	head->vor = (*del)->vor;
	(*del)->nach = head;
	
	return head;
}

void schleife(fach_note *liste, void (*ausgeben) (const fach_note *n))
{
	fach_note *p;
	for(p = liste ; p != NULL; p = p->nach )
	{
		
	}
}
