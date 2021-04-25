#!/bin/bash

docker-compose up -d
#kubectl apply -f k8s/cassandra.yml
kubectl apply -f k8s/zookeeper.yml
kubectl apply -f k8s/kafka.yml
#kubectl apply -f elk.yml
#kubectl apply -f grpc.yml