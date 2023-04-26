package com.example.realTemp.consumer;


import com.example.realTemp.config.MessageConfig;
import com.example.realTemp.entity.Drivers;
import com.example.realTemp.entity.OrderStatus;
import com.example.realTemp.entity.Vehical;
import com.example.realTemp.repository.DriverRepository;
import com.example.realTemp.repository.VehicalRepository;
import com.example.realTemp.service.DriverServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;


@Component

public class User {
    @Autowired
    DriverRepository dr;

    @Autowired
    VehicalRepository vr;

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) throws UnsupportedEncodingException, MessagingException {

        System.out.println("Message recieved from queue : " + orderStatus);

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        UUID id = orderStatus.getVehical().getVehicalId();
        Optional<Vehical> vehi = vr.findById(id);

        Vehical v = vehi.get();
        System.out.println(v.getDrivers().getEmail());
        String emailTo = v.getDrivers().getEmail();

        sender.setHost("127.0.0.1");
        sender.setPort(1025);

        System.out.println("Sending email");
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(new InternetAddress("Satyam@local.com", "Satyam"));
        helper.setSubject("Registered Successfully!");
        helper.setTo(emailTo);
        helper.setText("Thank you for Registering!");

        sender.send(message);


        System.out.println("Done bro");
    }


}
