# No Javascript Calculator Webapp
What should a calculator web app look like, if there is no Javascript?\
&nbsp; &nbsp; Project made with Java, JSP.

## Outline

1. Intro
1. Environment
1. Content
  * Description
  * Challenges Encountered
4. Known Issues
5. Future Development

## 1. Intro

What should a calculator web app look like, if there is no Javascript?
With this premise in mind, I made this project with Java, JSP, Servlet to try and make a basic calculator 
that relies fully on the back-end.

## 2. Environment

- Eclipse 2021-12
- Maven Archetype: maven-archetype-webapp 1.0
- JRE: J2SE 1.5
- Apache Tomcat: 9.0.5

## 3. Content

### How to Use

Click on number buttons on left panel and operators buttons on right panel in correct order.

### Description

Each buttons pressed are an individual request sent to the server. \
After the equal sign is clicked, result will be returned to the JSP page.

### Challenges Encountered (Resolved)
- Storing info between different requests
- Numbers are received by digit not by number
- Order of operations

## 4. Known issues

- Calculator Functionalities
  1. No "c" button to clear input
  2. Display of Result & Display of Input Bar
  3. Race Condition: &nbsp; Each button press is a independent request
  4. Decimal number calculations

- Basic Exceptions
  Right now, there are no precautions done to avoid exceptions breaking the app

## 5. Future Development

Aside from the known issues based on this Java & JSP project, there are still many possibilities to explore based on the "no JS" premise. /
A few things that can be further explored includes:
- What if JSTL and EL is used to full extent?
- What if JSTL and EL is fully removed (pure HTML)?
- What can CSS do (in terms of calculation and configuration of buttons)?
- Other ways to push HTML and its limitations.
