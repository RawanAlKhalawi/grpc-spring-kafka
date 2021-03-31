#!/bin/sh

openssl req -x509 -nodes -subj "/CN=localhost" -newkey rsa:4096 -sha256 -keyout server.key -out server.crt -days 3650
