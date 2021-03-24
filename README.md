
run the docker compose by
```
docker-compose up -d
```

generate sources
```
mvn compile
```

login to cassandra docker container
```
docker ps
docker exec -it container_id bash
cqlsh
describe keyspaces;
use my_keyspace_name;
describe tables;
select * from my_table_name
```

Generate Certificate using openssl
```
openssl req -x509 -nodes -subj "//CN=localhost" -newkey rsa:4096 -sha256 -keyout server.key -out server.crt -days 3650
```

Import cert to keystore
```sudo keytool -importcert -keystore /usr/local/java/jdk1.8.0_60/jre/lib/security/cacerts -storepass changeit -file ~/Downloads/RHEL-cert/root.crt -alias "rhel-root"```