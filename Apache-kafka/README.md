
# Apache kafka / Zookeeper commands

Command to start zookeeper and kafka:

`/opt/homebrew/bin/zookeeper-server-start /opt/homebrew/etc/zookeeper/zoo.cfg`

`/opt/homebrew/opt/kafka/bin/kafka-server-start /opt/homebrew/etc/kafka/server.properties`

General Commands: (`/opt/homebrew/opt/kafka/bin`)
- Creating a Kafka topic
`kafka-topics --create --topic user-topic --bootstrap-server localhost:9092`
- Writing events into the topic
`kafka-console-producer --topic user-topic --bootstrap-server localhost:9092`
- Read events from the topic
`kafka-console-consumer --topic user-topic --from-beginning --bootstrap-server localhost:9092`