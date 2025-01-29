package study.spring.rabbit.study.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import study.spring.rabbit.study.listener.dto.OrderCreatedEventDTO;
import study.spring.rabbit.study.services.OrderService;

import static study.spring.rabbit.study.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    private final OrderService orderService;

    public OrderCreatedListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEventDTO> message){
        logger.info("Message consumed: \n" + message);

        orderService.save(message.getPayload());
    }
}
