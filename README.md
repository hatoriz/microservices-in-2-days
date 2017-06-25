Microservices in 2 Days
=======================

Slides and workshop materials from 2-day training course on June 24-25, 2017 by Siam Chamnankit.

The original slides can be found from these repositories:

- https://github.com/up1/course_microservice_kmitl
- https://github.com/up1/course-microservice

Workshop 
--------

Git Repository: https://github.com/up1/workshop-ms-01
API Portal: https://anypoint.mulesoft.com/apiplatform/pacroy/#/portals/organizations/0aaa2d07-b513-44ef-b925-55d170acc9df/apis/21595906/versions/714733  
Root RAML: https://anypoint.mulesoft.com/apiplatform/repository/v2/organizations/0aaa2d07-b513-44ef-b925-55d170acc9df/public/apis/21595906/versions/714733/files/root

Course Outline
--------------

### Introduction of Evolution of Architecture

- Monolith
- Layer/Tier
- SOA
- Microservice
- FaaS/Serverless

### Design service

- Characteristic of Microservice
- Pattern of Microservice
- Communication patterns between services
- All about REST APIs
- Step to design REST APIs
- Workshop: Design your services and REST APIs

### Develop Microservice with Java (Spring Boot)

- Software requirements
- JDK 8
- Apache Maven
- IntelliJ IDE
- Workshop: Let’s start with Spring Boot
- How to developer service ?
- How to run service ?

### Testing services

- Testing strategy 
- Unit testing
- Integration testing
- Component testing
- Contract testing
- End-to-End testing
- Workshop: How to test your service ?
- Write your tests

### Monitoring

- Focusing on Application monitoring
- API usages
- Success rate/Failure rate
- Workshop: How to monitoring Microservice ?
- Tools
- Prometheus
- Grafana

### Deploy your service

- Evolution of Containerization
- Workshop: How to deploy Microservice ?
- Tools
- Docker
- Kubernates

Demo Instructions (macOS)
-------------------------

### Go

1) Install brew first using command `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`

2) Download and install Go by using command `brew install go` or download the installer from https://golang.org/dl/

3) Run demo.go using command `go run demo.go` and you will get error.

4) Use command `go env` to check GOPATH.

```
GOARCH="amd64"
GOBIN=""
GOEXE=""
GOHOSTARCH="amd64"
GOHOSTOS="darwin"
GOOS="darwin"
GOPATH="/Users/pacroy/go"
GORACE=""
GOROOT="/usr/local/go"
GOTOOLDIR="/usr/local/go/pkg/tool/darwin_amd64"
GCCGO="gccgo"
CC="clang"
GOGCCFLAGS="-fPIC -m64 -pthread -fno-caret-diagnostics -Qunused-arguments -fmessage-length=0 -fdebug-prefix-map=/var/folders/z9/509z92q528g_vyl_l8g72s7w0000gn/T/go-build813334616=/tmp/go-build -gno-record-gcc-switches -fno-common"
CXX="clang++"
CGO_ENABLED="1"
PKG_CONFIG="pkg-config"
CGO_CFLAGS="-g -O2"
CGO_CPPFLAGS=""
CGO_CXXFLAGS="-g -O2"
CGO_FFLAGS="-g -O2"
CGO_LDFLAGS="-g -O2"
```

5) Change GOPATH to your working directory using command `export GOPATH="(working dir)"` and check again with `go env`.

6) Download the package using command `go get github.com/prometheus/client_golang/prometheus/promhttp`

7) Run again using `go run demo.go` and go to http://localhost:8080  
You can see the service matrices at http://localhost:8080/prometheus/

8) Build the demo.go with command `go build demo.go`. You will get a binary executable file based on GOHOSTARCH and GOHOSTOS which you can deploy on a server right away.

### Node.js

1) Download and install Node.js from https://nodejs.org/en/

2) Install [Express](https://expressjs.com/) using command `npm install express --save`

3) Run our app using command `node main.js`

4) Go to http://localhost:3000/ or http://localhost:3000/about

5) You can run at specific port by using command `PORT=8000 node main.js`

6) To deploy on a server, you need to sintall Node.js first and you need package.json so the dependencies are downloaded and installed automatically when using command `node install`.  
To install as a single executable file, try using https://github.com/zeit/pkg (macOS and Linux)

### Java

1) Open Eclipse and create a new Maven Project

2) Open pom.xml and add below text right after `<name>...</name>` tag.


```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.apache.tomcat</groupId>
                    <artifactId>tomcat-jdbc</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-dbcp2</artifactId>
            <version>2.1.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>6.0.5</version>
        </dependency>

        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>com.moelholm</groupId>
            <artifactId>prometheus-spring-boot-starter</artifactId>
            <version>1.0.1</version>
        </dependency>

    </dependencies>


    <build>
        <finalName>demo-service</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

3) Click save and all dependencies will be downloaded automatically. Then the project will be built.

4) Create a new class `DemoApplication` in the folder /src/main/java

5) Replace the code with below excluding the package line.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String ... args){
        SpringApplication.run(DemoApplication.class, args);
    }

}
```

6) Create a new class `DemoControler` under .controller package in the folder /src/main/java

7) Add the following codes:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/")
	public String hello() {
		return "Hello from Spring Boot";
	}
	
	@GetMapping("/about")
	public String hello2() {
		return "About";
	}
}
```

8) Install Maven, if you haven't done so, using command `brew install maven`

9) Build the app using command `mvn clean package`

10) Run the app using command `java -jar target/demo-service.jar`

11) Go to http://localhost:8080/ or http://localhost:8080/about

Testing
-------

### Postman

```shell
Run in command line --> https://www.npmjs.com/package/newman
npm install newman --global;
newman run workshop-ms-01.postman_collection.json
```

- People who don't use Postman cannot easily understand Postman scripts (JSON).

### Silk

- Writen in Go
- Go to https://github.com/matryer/silk
- Write markdown and use it as test script
- The issue of Silk is it does not indicate error when the script is writen incorrectly.

1) Create a markdown file per guideline in the web

2) Install Silk using command `go get github.com/matryer/silk`. (Success returns blank.)  
`silk` will be in `~/go/bin`.

3) Run silk using command `~/go/bin/silk -silk.url=http://localhost:8080`. You will get:

```
silk: running 0 file(s)...
PASS
```

4) Add one more argument for the markdown file like this `~/go/bin/silk -silk.url=http://localhost:8080 your_markdown.md`

#### Exmaple Results

##### Failed

```shell
silk: running 1 file(s)...
Content-Type expected: "application/json"  actual: "application/json;charset=UTF-8"  
--- FAIL: GET /search/somkiat 
 /Users/pacroy/Documents/git/microservices-in-2-days/workshop/workshop-ms-01/CHAIRAT.md:21 - Content-Type doesn't match  
--- FAIL: silk (0.05s)
FAIL
```

##### Success

```shell
silk: running 1 file(s)...
PASS

```

### Robot Framework

- Requires Python
- Go to http://robotframework.org/ --> Libraries --> External --> HTTP library (Requests)
- Create a .robot file
- See example here: https://github.com/bulkan/robotframework-requests
- Run with command `pybot api.robot` 
- Open report with command `open report.html`

Monitoring
----------

### Prometheus

- Good at keeping metrics time-series data
- Built with Go
- Every services should have an endpoint for Prometeus to query data from the service. (Pull strategy) This is to prevent impact to the service from the monitoring service.
- Go: Run demo_prometheus.go for demo
- Node.js: Run main_prometheus.js for demo (Requires `npm install prom-client`)
- Java: Ready to use (already configured in pom.xml file). Go to /prometheus

1) Install Prometheus from https://prometheus.io/

2) Run prometheus

3) Go to http://localhost:9090

4) Input expression `tsdb_samples_appended_total` to see metric of itself

5) Stop and edit the config file `prometheus.yml`

6) Edit the config to add your services under `scrape_configs`. For example:

```yml
  - job_name: 'demo_nodejs'
    scrape_interval: 5s
    metrics_path: '/prometheus'
    static_configs:
      - targets: ['localhost:3000']
      
  - job_name: 'demo_java'
    scrape_interval: 5s
    metrics_path: '/prometheus'
    static_configs:
      - targets: ['localhost:8080']
```

7) Start the Prometheus again and add the desired matrics

### Grafana

- Visualization tool only

1) Download from https://grafana.com/

```shell
brew update
brew install grafana
```

2) Edit the config file (/usr/local/etc/grafana/grafana.ini) to configure the HTTP port e.g. 3030

3) Start Grafana with command:

```
grafana-server --config=/usr/local/etc/grafana/grafana.ini --homepath /usr/local/share/grafana cfg:default.paths.logs=/usr/local/var/log/grafana cfg:default.paths.data=/usr/local/var/lib/grafana cfg:default.paths.plugins=/usr/local/var/lib/grafana/plugins
```

4) Go to http://localhost:3030

5) Log in with admin:admin

6) Add data source Prometheus

6) Import Dashboards. This is the dashboard of Prometheus itself

7) New dashboard --> Add Graph

8) Configure graph to add metrics you want

More
----

- Deployment --> Containerization
- Service Discovery
- Load Balancing
- Fault Torelance