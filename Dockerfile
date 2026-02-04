FROM maven:3.9.11-eclipse-temurin-17

# Install Chrome
RUN apt-get update && apt-get install -y \
    wget unzip \
 && wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
 && apt-get install -y ./google-chrome-stable_current_amd64.deb

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

CMD ["mvn", "test"]
