//package com.example.realTemp.publisher;
//
//
//import com.example.realTemp.config.MessageConfig;
//import com.example.realTemp.entity.OrderStatus;
//import com.example.realTemp.entity.Vehical;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/order")
//public class OrderPublisher {
//
//    @Autowired
//    private RabbitTemplate template;
//
//    @PostMapping("/{showRoomName}")
//    public String bookOrder(@RequestBody Vehical vehical, @PathVariable String showRoomName) {
//
//        //payment service
//        OrderStatus orderStatus = new OrderStatus(vehical, "PROCESS", "order placed succesfully in " + showRoomName);
//        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, orderStatus);
//        return "Success !!";
//    }
//}
