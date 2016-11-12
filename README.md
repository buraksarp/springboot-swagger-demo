Spring Boot Swagger Demo
=========================

Building the Application
---------------------
    $ git clone https://github.com/buraksarp/springboot-swagger-demo.git
    $ cd swagger-vod-demo
    $ mvn clean install

This demo assumes you know how to run Docker.

Building the Container
----------------------
Nothing special if you already have Docker installed:

    $ docker build -t spring-boot/swagger-vod-demo .

Running the Container
---------------------
To run this container:

    $ docker run -ti spring-boot/swagger-vod-demo

To view the generated Swagger UI documentation go to: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

