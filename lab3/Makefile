#------------------------------------------------------------------------------
# Makefile
# Pattawut Manapongpun
# pmanapon
# CMPS-12M
# Date: 2-1-2018
# Makefile with macros of lab3
#------------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
SOURCES = FileReverse.c
OBJECTS = FileReverse.o
EXEBIN = FileReverse
SOURCES_SUBMIT = README Makefile $(SOURCES)
SUBMIT = submit cmps012b-pt.w18 lab3


all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

submit: $(SOURCES_SUBMIT)
	$(SUBMIT) $(SOURCES_SUBMIT)

check:
	ls  /afs/cats.ucsc.edu/class/cmps012b-pt.w18/lab3/pmanapon