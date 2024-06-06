1. mvn clean install
   - repackage plugin makes it a proper executable jar with spring

2. docker build -t danyeu/hello-world:spring-docker .

3. docker run -p 8080:8080 danyeu/hello-world:spring-docker
   - need to port forward external:internal