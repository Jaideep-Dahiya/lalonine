# 📌 HOW TO RUN

## 🚀 Start PostgreSQL Container & Run Application
To run PostgreSQL with specific properties from `application.properties`, ensure that the container is started properly before launching the application.

---

## 🛠️ Kafka Setup

### 🔹 Create a Kafka Topic
```sh
kafka-topics.sh --create --topic test-topic \
--bootstrap-server host.docker.internal:9094 \
--partitions 3 \
--replication-factor 3 \
--config min.insync.replicas=2
```
These properties help fine-tune Kafka topic behavior:
- `--partitions 3` ➝ Defines 3 partitions for the topic.
- `--replication-factor 3` ➝ Ensures 3 replicas for fault tolerance.
- `--config min.insync.replicas=2` ➝ Requires at least 2 replicas to acknowledge before writing.

### 🔍 List Topics
```sh
kafka-topics.sh --list --bootstrap-server host.docker.internal:9092
```

### 🔄 Hostname Configuration
`${HOSTNAME:-localhost}` ➝ This means:
- If `HOSTNAME` is set, it will be used.
- Otherwise, `localhost` is used as the default.

### 📡 Listener Explanation
- `listeners` ➝ Defines how the broker itself listens for connections.
- `advertised.listeners` ➝ Defines what the broker communicates to clients on how to reach it.

### 📂 Kafka Directory
Navigate to the Kafka bin directory:
```sh
cd opt/bitnami/kafka/bin
```

### 🔗 Execute Kafka Commands from Outside the Container
```sh
docker exec -it demo-kafka-1-1 bash
```

### 📥 Consume Messages from Kafka
```sh
kafka-console-consumer.sh --topic product-created-events-topic \
--from-beginning --bootstrap-server host.docker.internal:9092 \
--property print.key=true
```

### 📤 Produce Messages with Key-Value Pair
```sh
kafka-console-producer.sh --bootstrap-server host.docker.internal:9096 \
--topic product-created-events-topic \
--property "parse.key=true" --property "key.separator=:
```

---

## 🐳 Docker Compose Setup
```sh
docker compose -f dockerfile-kafka.yaml --env-file .env up -d
```
Since we attach an IP address to Docker Compose, update and set it every time.

### 🌍 Find Your Local IP Address
- **Mac**: `ipconfig getifaddr en0`
- **Windows**: `ipconfig | findstr IPv4` (May need adjustment)

---

## ☕ Spring Kafka Setup

### ✅ Steps:
1. **Add Kafka Properties** to `application.properties` 🛠️
2. **Create Kafka Config** for bean setup ⚙️
3. **Implement Consumer** with Kafka Listener 👂
4. **Add Error Handling** for Deserialization 🚨

---

💡 *This guide ensures a seamless Kafka & PostgreSQL setup. Happy coding!* 🚀

