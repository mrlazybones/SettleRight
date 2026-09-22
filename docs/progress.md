# Progress checkpoint

## Current milestone and step

Milestone 0. Next incomplete step: 0.5 (generate and run the smallest Spring Boot app).

## Implemented functionality

None yet. Workspace and Git only.

## Verified tests and commands

- `java -version` and `javac -version`: 25.0.3
- `JAVA_HOME` (user): `C:\Program Files\Java\jdk-25.0.3`
- `git version 2.55.0.windows.3`
- `core.autocrlf=true`
- Docker Desktop 4.91.0, Engine 29.8.0
- `docker run hello-world` printed `Hello from Docker!`
- `wsl -l -v`: `docker-desktop` Running / VERSION 2; `Ubuntu-20.04` Stopped / VERSION 1 (left as-is)

## Concepts learned

- JRE vs JDK; `PATH` vs `JAVA_HOME`
- User-level environment variables override system-level ones
- WSL 1 vs WSL 2; Docker Desktop uses its own WSL 2 distro
- Windows line endings and `core.autocrlf`

## Decisions made

- Use existing Oracle JDK 25 LTS (not Java 21). Spring Boot 3.5.5+ / 4.x support Java 25.
- UI: Thymeleaf plus modest JavaScript (no React).
- Cloud: free tier only; local Kubernetes later.
- Leave `Ubuntu-20.04` on WSL 1; Docker does not need that distro.

## Unresolved problems

None blocking Milestone 0.

## Next small task

Step 0.5 — generate the smallest suitable Spring Boot application and start it.
