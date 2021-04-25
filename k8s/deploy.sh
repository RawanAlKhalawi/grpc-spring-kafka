#!/bin/bash

kubectl apply -f cassandra.yml
kubectl apply -f zookeeper.yml
kubectl apply -f kafka.yml
#kubectl apply -f elk.yml
#kubectl apply -f grpc.yml