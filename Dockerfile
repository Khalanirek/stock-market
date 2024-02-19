FROM openjdk:17-jdk-slim

COPY target/stock-market-0.0.1-SNAPSHOT.jar /stock-market.jar

CMD ["java", "-jar", "stock-market.jar"]