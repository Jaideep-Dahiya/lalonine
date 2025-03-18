# HOW TO RUN

start postgres container run application
run postgres with specific properties from application.properties


# KAFKA
kafka-topics.sh --create --topic test-topic --bootstrap-server host.docker.internal:9094
--partitions 3 
--replication-factor 3
--config min.insync.replicas=2 
these are the 3 properties you can add to have more control

kafka-topics.sh --list --bootstrap-server host.docker.internal:9092

${HOSTNAME:-localhost} => means if hostname set use that otherwise use localhost

listeners is for the broker itself, while advertised.listeners is what the broker tells others about how to reach it. 🚀

cd opt/bitnami/kafka/bin

docker exec -it demo-kafka-1-1 bash => execute commands from outside

kafka-console-consumer.sh --topic product-created-events-topic --from-beginning --bootstrap-server host.docker.internal:9092 --property print.key=true

kafka-console-producer.sh --bootstrap-server host.docker.internal:9096 --topic product-created-events-topic --property "parse.key=true" --property "key.separator=:" => with key value pair 

docker compose -f dockerfile-kafka.yaml --env-file .env up -d
since we attached IP address to docker compose change it and set it everytime
ipconfig getifaddr en0 => find with this in mac
ipconfig | findstr IPv4 => this for windows not sure fully 
# SPRING KAFKA 

SETUP 
-> added properties in application.properties
-> created kafka config for bean setup
-> COnsumer needs kafka listener
-> error deserialization added