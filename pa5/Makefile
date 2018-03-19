#------------------------------------------------------------------------------
# Makefile
# Pattawut Manapongpun
# pmanapon
# CMPS-12B
# Date: 3-15-2018
# Makefile for pa5
#------------------------------------------------------------------------------

ADT     = Dictionary
EXEBIN  = $(ADT)Client
SOURCES = $(ADT).c $(EXEBIN).c
OBJECTS = $(ADT).o $(EXEBIN).o
HEADERS = $(ADT).h
SOURCES_SUBMIT = README Makefile DictionaryTest.c $(SOURCES) $(HEADERS) 
SUBMIT = submit cmps012b-pt.w18 pa5

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
	ls  /afs/cats.ucsc.edu/class/cmps012b-pt.w18/pa5/pmanapon

