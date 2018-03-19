#------------------------------------------------------------------------------
# Makefile
# Pattawut Manapongpun
# pmanapon
# CMPS-12M
# Date: 2-20-2018
# Makefile for lab5
#------------------------------------------------------------------------------

ADT_NAME  = Dictionary
SOURCES   = $(ADT_NAME).c $(ADT_NAME)Client.c
OBJECTS   = $(ADT_NAME).o $(ADT_NAME)Client.o
HEADERS   = $(ADT_NAME).h
EXEBIN    = $(ADT_NAME)Client
FLAGS     = -std=c99 -Wall
SOURCES_SUBMIT = README Makefile DictionaryTest.c $(SOURCES) $(HEADERS) 
SUBMIT = submit cmps012b-pt.w18 lab5

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 

submit: $(SOURCES_SUBMIT)
	$(SUBMIT) $(SOURCES_SUBMIT)

submitcheck:
	ls  /afs/cats.ucsc.edu/class/cmps012b-pt.w18/lab5/pmanapon
