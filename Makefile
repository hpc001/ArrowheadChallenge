#
# A simple makefile for compiling three java classes
#

# define a makefile variable for the java compiler
#
JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: IValidationEngine.class Skeleton.class IValidationResult.class Ivalres.class

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
IValidationEngine.class: IValidationEngine.java
        $(JCC) $(JFLAGS) IValidationEngine.java

Skeleton.class: Skeleton.java
        $(JCC) $(JFLAGS) Skeleton.java

IValidationResult.class: IValidationResult.java
        $(JCC) $(JFLAGS) IValidationResult.java

Ivalres.class: Ivalres.java
        $(JCC) $(JFLAGS) Ivalres.java
# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
        $(RM) *.class