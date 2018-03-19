//-----------------------------------------------------------------------------
//  hello.c
//  Prints "Hello World!", then displays some environment data.
// 
//  Every unix process has a vector of environment variables that is passed 
//  to it, such as the shell variables $PATH, $HOME, etc.  This program 
//  prints them out.
//-----------------------------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>

#define HELLO_STRING "Hello World!\n"

extern char** environ;

int main( void ){
   int i;

   printf(HELLO_STRING);
   for( i = 0; environ[i] != NULL; i++ ){
      printf("environ[%d]=(%s)\n", i, environ[i]);
   }
   return EXIT_SUCCESS;
}

