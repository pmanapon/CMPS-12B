#------------------------------------------------------------------------------
# Makefile
# Pattawut Manapongpun
# pmanapon
# CMPS-12M
# Date: 2-10-2018
# Makefile for lab4
#------------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
SOURCES = charType.c
OBJECTS = charType.o
EXEBIN = charType
SOURCES_SUBMIT = README Makefile $(SOURCES)
SUBMIT = submit cmps012b-pt.w18 lab4


all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full charType in out

submit: $(SOURCES_SUBMIT)
	$(SUBMIT) $(SOURCES_SUBMIT)

submitcheck:
	ls  /afs/cats.ucsc.edu/class/cmps012b-pt.w18/lab4/pmanapon