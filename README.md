
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