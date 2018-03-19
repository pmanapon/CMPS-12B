//-----------------------------------------------------------------------------
// DictionaryTest.c
// Pattawut Manapongpun
// pmanapon
// CMPS-12M
// Date: 2-20-2018
// Tests Dictionary ADT.
//-----------------------------------------------------------------------------


#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Dictionary.h"

int main(int argc, char* argv[]){
   Dictionary A = newDictionary();

   printf("%s\n", (isEmpty(A)?"true":"false"));
   insert(A,"1","one");
   insert(A,"2","two");
   insert(A,"3","three");
   printf("%s\n", (isEmpty(A)?"true":"false"));

   printDictionary(stdout, A);
   delete(A,"1");
   delete(A,"3");
   printDictionary(stdout, A);
   // delete(A,"5");  // error
   insert(A,"5","five");
   delete(A,"2");
   printf("%s\n", (isEmpty(A)?"true":"false"));
   printDictionary(stdout, A);  
   insert(A,"10","ten");
   printDictionary(stdout, A);
   freeDictionary(&A);
   //printDictionary(stdout, A);  //error
   //insert(A,"1","one");  //error

   Dictionary B = newDictionary();

   printf("%s\n", (isEmpty(B)?"true":"false"));
   insert(B,"1","one");
   insert(B,"2","two");
   insert(B,"3","three");
   printf("%s\n", (isEmpty(B)?"true":"false"));
   printDictionary(stdout, B);
   makeEmpty(B);
   printf("%s\n", (isEmpty(B)?"true":"false")); //prints true;
   freeDictionary(&B);

   return(EXIT_SUCCESS);
  
}