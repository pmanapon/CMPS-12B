//-----------------------------------------------------------------------------
// charType.c
// Pattawut Manapongpun
// pmanapon
// CMPS-12M
// Date: 2-10-2018
// Classifies the characters on each line of the input file into categories.
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>
#include<string.h>

#define MAX_STRING_LENGTH 100

// function prototype 
void extract_chars(char* s, char* a, char* d, char* p, char* w);
// function main which takes command line arguments 
int main(int argc, char* argv[]){
   FILE* in;        // handle for input file                  
   FILE* out;       // handle for output file                 
   char* line;      // string holding input line              
   // char* alpha_num; // string holding all alpha-numeric chars 
   char* a;         //  alphabetic chars
   char* d;         //  digit chars
   char* p;         //  punctuation chars
   char* w;         //  whitespace chars
   int n = 1;       //  line number 

   // check command line for correct number of arguments 
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   // open input file for reading 
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing 
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   // allocate strings line and alpha_num on the heap 
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   // alpha_num = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   a = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   d = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   p = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   w = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line!=NULL && a!=NULL && d!=NULL && p!=NULL && w!=NULL );

   // read each line in input file, extract alpha-numeric characters 
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      // extract_alpha_num(line, alpha_num);
      extract_chars(line, a, d, p, w);
      fprintf(out, "line %d contains:\n", n++);
      if(strlen(a)>1)
         fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(a), a);
      else
         fprintf(out, "%d alphabetic character: %s\n", (int)strlen(a), a);

      if(strlen(d)>1)
         fprintf(out, "%d numeric characters: %s\n", (int)strlen(d), d);
      else
         fprintf(out, "%d numeric character: %s\n", (int)strlen(d), d);
      
      if(strlen(p)>1)
         fprintf(out, "%d punctuation characters: %s\n", (int)strlen(p), p);
      else
         fprintf(out, "%d punctuation character: %s\n", (int)strlen(p), p);

      if(strlen(w)>1)
         fprintf(out, "%d whitespace characters: %s\n", (int)strlen(w), w);
      else
         fprintf(out, "%d whitespace character: %s\n", (int)strlen(w), w);
   }

   // free heap memory 
   free(line);
   // free(alpha_num);
   free(a);
   free(d);
   free(p);
   free(w);

   // close input and output files 
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition 
void extract_chars(char* s, char* a, char* d, char* p, char* w){
   int i=0;
   int j=0, k=0, l=0, m=0;
   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      // if( isalnum( (int) s[i]) ) a[j++] = s[i];
      //isalnum(), isalpha(), isdigit(), ispunct(), and isspace()
      if(isalpha((int)s[i])) 
         a[j++] = s[i];
      else if(isdigit((int)s[i])) 
         d[k++] = s[i];
      else if(ispunct((int)s[i])) 
         p[l++] = s[i];
      else if(isspace((int)s[i])) 
         w[m++] = s[i];
      
      i++;
   }
   a[j] = '\0';
   d[k] = '\0';
   p[l] = '\0';
   w[m] = '\0';
}