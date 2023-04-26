package com.example.realTemp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class RealTempApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTempApplication.class, args);
	}

}
