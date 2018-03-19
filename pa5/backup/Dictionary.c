//-----------------------------------------------------------------------------
// Dictionary.c
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 3-15-2018
// Implementation of Dictionary ADT based on Hash table.
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"


// private types --------------------------------------------------------------

// NodeObj
typedef struct NodeObj{
   char* key;
   char* value;
   struct NodeObj* next;
} NodeObj;

// Node
typedef NodeObj* Node;

// newNode()
// constructor of the Node type
Node newNode(char* x, char* y) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->key = x;
   N->value = y;
   N->next = NULL;
   return(N);
}

// freeNode()
// destructor for the Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free(*pN);
      *pN = NULL;
   }
}

// DictionaryObj
typedef struct DictionaryObj{
   Node *table;
   int numItems;
} DictionaryObj;



const int tableSize=101; // or some prime other than 101

// rotate_left()
// rotate the bits in an unsigned int
unsigned int rotate_left(unsigned int value, int shift) {
   int sizeInBits = 8*sizeof(unsigned int);
   shift = shift & (sizeInBits - 1);
   if ( shift == 0 )
      return value;
   return (value << shift) | (value >> (sizeInBits - shift));
}
// pre_hash()
// turn a string into an unsigned int
unsigned int pre_hash(char* input) {
   unsigned int result = 0xBAE86554;
   while (*input) {
      result ^= *input++;
      result = rotate_left(result, 5);
   }
   return result;
}
// hash()
// turns a string into an int in the range 0 to tableSize-1
int hash(char* key){
   return pre_hash(key)%tableSize;
}

// public functions -----------------------------------------------------------

// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(void){
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D!=NULL);
   D->table = calloc(tableSize,sizeof(NodeObj));
   assert(D->table!=NULL);
   D->numItems = 0;
   return D;
}

// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pD){
   if( pD!=NULL && *pD!=NULL ){
      makeEmpty(*pD);
      free((*pD)->table);
      free(*pD);
      *pD = NULL;
   }
}

// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return(D->numItems==0);
}

// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling size() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return D->numItems;
}


Node findKey(Dictionary D, char* k){
   Node N;
   N = D->table[hash(k)];
   while(N != NULL){
      if(strcmp(N->key,k)== 0)
         break;
      N = N->next;
   }
   return N;
}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no 
// such value v exists.
// pre: none
char* lookup(Dictionary D, char* k){

   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling lookup() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }

   if(findKey(D,k) == NULL)
      return NULL;
   else
      return findKey(D,k)->value;
}

// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary D, char* k, char* v){
   
   int i = hash(k);
   Node N = newNode(k,v);

   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling insert() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if( findKey(D,k)!=NULL ){
      fprintf(stderr, "Dictionary Error: cannot insert() duplicate key: \"%s\"\n", k);
      exit(EXIT_FAILURE);
   }

   N->next = D->table[i];
   D->table[i] = N;
   N = NULL;
   D->numItems++;
}

// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
void delete(Dictionary D, char* k){
   Node N;
 
   int i = hash(k);

   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }

   if( findKey(D,k)==NULL ){
      fprintf(stderr, "Dictionary Error: cannot delete() non-existent key: \"%s\"\n", k);
      exit(EXIT_FAILURE);
   }

   if(findKey(D, k) == D->table[i]){
      N = D->table[i];
      D->table[i] = D->table[i]->next;
      N->next = NULL;
   }
   else{
      N = findKey(D, k);
      Node prev = D->table[i];
      Node temp = D->table[i]->next;
      while(temp != N){
         temp = temp->next;
         prev = prev->next;
      }
      prev->next = N->next;
      N->next = NULL;
   }
   freeNode(&N);
   D->numItems--;
}

// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D){
   for(int i = 0; i<tableSize; i++){
      while(D->table[i] != NULL){
         Node N;
         N = D-> table[i];
         D->table[i]=N->next;
         freeNode(&N);
         N = NULL;
      }
   }D->numItems = 0; 
}

// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE* out, Dictionary D){
   if(D == NULL){
      fprintf(stderr, "Dictionary Error: calling printDictionary() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   Node N;
   for(int i = 0; i<tableSize; i++){
      N = D->table[i];
      while(N!=NULL){
         fprintf(out, "%s %s\n", N->key, N->value);
         N = N->next;
      }
   }
}