# What to do with this?

- You need Java 8 and Maven 3.x

- Just go into `nio` (non-blocking with netty) or `plain` (embedded blocking tomcat) 
  and do a 
  ```
  mvn spring-boot:run
  ```

- This will spin up a webserver, which you can call on
  ```
  curl -i "http://localhost:8080"
  ```
  Now you have to wait for the response, by default 10 seconds.
  
- There is also a `GET /health` endpoint, e.g. for AWS ELB

- You can specify the waiting time either in the `application.properties` or via 
  a environment variable `SLEEP_SECS`