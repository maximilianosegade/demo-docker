#!/bin/bash
# Script for building image and run container.

# Compile binary.
mvn clean install

# Build image.
docker build -t demo-app .

# Default config: Expose app in port 8080 and persist with in-memory H2-DB 
EXPOSE_PORT="8080:8080"
DB_CONFIG="-e spring.datasource.url=jdbc:h2:mem:testdb \
    -e spring.datasource.driverClassName=org.h2.Driver \
    -e spring.datasource.username=sa \
    -e spring.datasource.password=password \
    -e spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"

# Run container.
docker run --rm -p $EXPOSE_PORT $DB_CONFIG demo-app