#!/bin/bash

# Run Docker and K8s
#docker-compose up -d
#kubectl apply -f k8s/cassandra.yml
#kubectl apply -f k8s/zookeeper.yml
#kubectl apply -f k8s/kafka.yml
#kubectl apply -f elk.yml
#kubectl apply -f temp.yml
#kubectl apply -f grpc.yml

#setting up APM Agent
java -javaagent:../lib/elastic-apm-agent-1.23.0.jar \
     -Delastic.apm.service_name=appointments-booking \
     -Delastic.apm.server_url=http://localhost:8200 \
     -Delastic.apm.application_packages=com.lama.appointmentsbooking \
     -jar ../target/appointments-booking-0.0.1-SNAPSHOT.jar

# Stop Docker and K8s
#docker-compose down
#kubectl delete daemonsets,replicasets,services,deployments,pods,jobs,rc,statefulset,configmap --all
