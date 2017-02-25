# BibliographySystem
Web app displays list of books from file for authorized users.

Used technologies are:
- Java core, Spring Framework on the server-side;
- Angular, JavaScript, HTML5 and CSS on the front-side;
- Maven as build automation tool

Running the project:
Run Local (Embedded Tomcat):
- execute: mvn tomcat7:run
- Then open the URL: http://localhost:8080/BibliographySystem/

Run inside tomcat container:
- package it with maven
- execute: mvn clean -> mvn install
- copy the result war file into your tomcat/webapp folder
- Then open the URL: http://localhost:8080/BibliographySystem/
