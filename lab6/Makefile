#------------------------------------------------------------------------------
# Makefile
# Pattawut Manapongpun
# pmanapon
# CMPS-12M
# Date: 2-26-2018
# Makefile for lab6
#------------------------------------------------------------------------------

# Variables
JARFILE    = ListClient
MAINCLASS  = ListClient
SOURCES    = List.java ListInterface.java ListClient.java\
             ListIndexOutOfBoundsException.java
CLASSES    = List.class ListInterface.class ListClient.class List\$$Node.class\
             ListIndexOutOfBoundsException.class

SOURCES_SUBMIT 	= README Makefile ListTest.java $(SOURCES) 
SUBMIT 		= submit cmps012b-pt.w18 lab6

# Build Targets
all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac -Xlint $(SOURCES)  

clean:
	rm -f $(CLASSES) $(JARFILE)

submit: $(SOURCES_SUBMIT)
	$(SUBMIT) $(SOURCES_SUBMIT)

check:
	ls  /afs/cats.ucsc.edu/class/cmps012b-pt.w18/lab6/pmanapon



