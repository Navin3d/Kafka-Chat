# Kafka-Chat
This is an basic chatting application using Apache Kafka and WebSocket.


domain:
 kafka:
  consumer:
   "[bootstrap.servers]": "localhost:29092"
   "[group.id]": "adults"
   "[auto.offset.reset]": "earliest"
   "[key.deserializer]": "org.apache.kafka.common.serialization.StringDeserializer"
   "[value.deserializer]": "org.apache.kafka.common.serialization.StringDeserializer"
  producer:
   "[bootstrap.servers]": "localhost:29092"
   "[key.serializer]": "org.apache.kafka.common.serialization.StringSerializer"
   "[value.serializer]": "org.apache.kafka.common.serialization.StringSerializer"
