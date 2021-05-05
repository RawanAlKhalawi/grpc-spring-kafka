#!/bin/bash

# Run Docker and K8s
#docker-compose up -d
#kubectl apply -f k8s/cassandra.yml
#kubectl apply -f k8s/zookeeper.yml
#kubectl apply -f k8s/kafka.yml
kubectl apply -f elk.yml
#kubectl apply -f temp.yml
#kubectl apply -f grpc.yml

# Stop Docker and K8s
#docker-compose down
#kubectl delete daemonsets,replicasets,services,deployments,pods,jobs,rc,statefulset,configmap --all
