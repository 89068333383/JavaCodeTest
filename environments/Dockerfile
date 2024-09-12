FROM vegardit/graalvm-maven:latest-java21 as builder

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src/

RUN mvn -Pnative native:compile

FROM vegardit/graalvm-maven:latest-java21

COPY --from=builder /app/target/graalvm-project /app/

CMD ["/app/graalvm-project"]