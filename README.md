# Requirements
Java 17 https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
Maven 3.9.6 https://maven.apache.org/download.cgi
Docker + Docker Compose https://docs.docker.com/engine/install/ubuntu/

# How to run
Everything what is needed can be run and clean using these 2 scripts:
- start.sh - start environment
- stop.sh - close environment. Docker creates a new image every time the application is build. Remember to sometimes clean not used images.

Test if application is available http://localhost:8080/