#define ALLOCSIZE 10000

static char allocbuf[ALLOCSIZE];  /* Storage for alloc */
static char *allocp = allocbuf;   /* Next free position */

char *alloc(int n){ /* Return the pointer to the n characters */
	if(allocbuf + ALLOCSIZE - allocp >= n){ /* it fits */
		allocp += n;
		return (allocp-n); /* old p */
	} else { 
		return 0;
	}
} 
