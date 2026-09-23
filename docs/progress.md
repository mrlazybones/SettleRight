# Progress checkpoint

## Current milestone and step

Milestone 0 complete. Next: Milestone 1, Step 1.1 (first user story). No business logic yet.

## Implemented functionality

Minimal Spring Boot 4.1.1 application. `GET /` returns 404 because no controller exists.

## Verified tests and commands

- `java -version` and `javac -version`: 25.0.3
- `JAVA_HOME` (user): `C:\Program Files\Java\jdk-25.0.3`
- `git version 2.55.0.windows.3`
- `core.autocrlf=true`
- Docker Desktop 4.91.0, Engine 29.8.0
- `docker run hello-world` printed `Hello from Docker!`
- `wsl -l -v`: `docker-desktop` Running / VERSION 2; `Ubuntu-20.04` Stopped / VERSION 1 (left as-is)
- `.\mvnw.cmd spring-boot:run`: Spring Boot 4.1.1, Java 25.0.3, Tomcat on port 8080
- Browser `http://localhost:8080`: Whitelabel 404
- `.\mvnw.cmd test`: Tests run: 1, Failures: 0, BUILD SUCCESS

## Concepts learned

- JRE vs JDK; `PATH` vs `JAVA_HOME`
- User-level environment variables override system-level ones
- WSL 1 vs WSL 2; Docker Desktop uses its own WSL 2 distro
- Windows line endings and `core.autocrlf`
- Maven reads `pom.xml`, downloads dependencies, compiles, and tests
- Maven Wrapper pins Maven 3.9.16; embedded Tomcat starts inside the JVM
- JVM needs `main`; `@SpringBootApplication` does not replace it
- `<scope>test</scope>` keeps test libraries out of the running app

## Decisions made

- Use existing Oracle JDK 25 LTS (not Java 21). Spring Boot 3.5.5+ / 4.x support Java 25.
- UI: Thymeleaf plus modest JavaScript (no React).
- Cloud: free tier only; local Kubernetes later.
- Leave `Ubuntu-20.04` on WSL 1; Docker does not need that distro.
- Spring Boot 4.1.1 with `spring-boot-starter-webmvc` only. Java version in `pom.xml` is 25.

## Unresolved problems

None blocking Milestone 0.

## Next small task

Step 1.1 — write the first user story for import and reconcile, with acceptance criteria. No new code until that story is agreed.
