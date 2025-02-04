package study.spring.rabbit.study.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.spring.rabbit.study.controllers.dto.ApiResponseDTO;
import study.spring.rabbit.study.controllers.dto.OrderResponseDTO;
import study.spring.rabbit.study.controllers.dto.PaginationResponseDTO;
import study.spring.rabbit.study.services.OrderService;

import java.util.Map;

@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService orderService) {
        this.service = orderService;
    }

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<ApiResponseDTO<OrderResponseDTO>> listOrders(
            @PathVariable("customerId") Long customerId,
            @RequestParam(name = "page", defaultValue = "0")Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize) {

        var pageResponse = service.findAllByCustomerId(customerId, PageRequest.of(page, pageSize));
        var totalOnOrders = service.findTotalOnOrdersByCustomerId(customerId);

        return ResponseEntity.ok(new ApiResponseDTO<>(
                Map.of("totalOnOrders", totalOnOrders),
                pageResponse.getContent(),
           PaginationResponseDTO.fromPage(pageResponse)
        ));
    }
}
