#syntax=docker/dockerfile:1
#Which "office Java image"?
#this image extend image oraclelinux8
FROM openjdk:17-oracle
#working directoriy
#khai bao khong gian lam vic tren container
WORKDIR /app
#copy host(PC,laptop) to container
COPY .mvn .mvn
COPY mvnw pom.xml ./
#Run this insite to image
RUN ./mvnw dependency:go-offline
COPY src ./src
#run cmd container
CMD ["./mvnw", "spring-boot:run"]

#buil image lenh nay chay ngoai
#Chay tren CMD.
#docker build --tag java-docker .