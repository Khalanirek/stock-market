# Requirements
Java 17 https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
Maven 3.9.6 https://maven.apache.org/download.cgi
Docker + Docker Compose https://docs.docker.com/engine/install/ubuntu/

# How to run
Everything what is needed can be run and clean using these 2 scripts:
- start.sh - start environment
- stop.sh - close environment. Docker creates a new image every time the application is build. Remember to sometimes clean not used images.

Test if application is available http://localhost:8080/

# Project architecture.
Project is divided into following business contexts:
account
company
investment portfolio
investor
order

Each context is divided into packages:
domain	        - business logic
dto		        - public shared class
infrastructure	- input from outside

Every context has only 2 inputs *CommandFacade and *QueryFacade, which are only public classes in the domain package.
Apart from these contexts, there are following infrastructural contexts:
avro			- contains all avro classes
common		    - some common classes shared by other contexts
communication	- single application output, sends messages
infrastructure	- configuration classes responsible for infrastructure
processor		- simple processor architecture to copy messages