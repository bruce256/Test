package rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.time.LocalDateTime;

/**
 * @author LvSheng
 * @date 2022/1/1
 **/
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
            DefaultMQProducer("test_group");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 18; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                "TagA" /* Tag */,
                ("Hello RocketMQ " +
                    i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            msg.setDelayTimeLevel(i + 1);
            //Call send message to deliver message to one of brokers.
            SendResult    sendResult    = producer.send(msg);
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.printf("send time =%s, %s%n", localDateTime, sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
