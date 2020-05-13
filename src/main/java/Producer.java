import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "77.55.220.159:9092, 77.55.220.159:9093, 77.55.220.159:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");

        KafkaProducer<Number, String> producer = new KafkaProducer<Number, String>(props);

        int numOfRecords = 100;

        for (int i = 0; i < numOfRecords; i++) {
            System.out.println("Message " + i + " was just produced.");
            producer.send(new ProducerRecord<Number, String>("numbers", i, Integer.toString(i)));
        }

        producer.close();

    }

}
