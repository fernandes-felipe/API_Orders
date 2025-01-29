package study.spring.rabbit.study.listener.dto;

import java.util.List;

public record OrderCreatedEventDTO(
        Long codigoPedido,
        Long codigoCliente,
        List<OrderItemEvent> itens
) {}
