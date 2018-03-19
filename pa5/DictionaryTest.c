//-----------------------------------------------------------------------------
// DictionaryTest.c
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 3-15-2018
// Tests Dictionary ADT.
//-----------------------------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include "Dictionary.h"

int main(void){
   Dictionary D = newDictionary();
   printf("%s\n", (isEmpty(D)?"true":"false"));
   insert(D,"one","1");
   insert(D,"two","2");
   insert(D,"three","3");
   insert(D,"four","4");
   insert(D,"five","5");
   insert(D,"six","6");
   insert(D,"seven","7");
   insert(D,"eight","8");
   insert(D,"nine","9");
   insert(D,"ten","10");
   insert(D,"eleven","11");
   insert(D,"twelve","12");
   printf("%s\n", (isEmpty(D)?"true":"false"));
   printDictionary(stdout,D);

   delete(D,"ten");
   delete(D,"five");
   //delete(D,"ten");
   
   printDictionary(stdout,D);
   
   makeEmpty(D);
   printf("%s\n", (isEmpty(D)?"true":"false"));
   printDictionary(stdout,D);

}