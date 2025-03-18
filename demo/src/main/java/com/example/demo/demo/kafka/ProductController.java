package com.example.demo.demo.kafka;

import com.example.storeFile.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/product")
public class ProductController {

    KafkaTemplate<String,ProductDto> kafkaTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ProductController(KafkaTemplate<String,ProductDto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<ProductDto> sendEvent(@RequestBody ProductDto productDto){

        CompletableFuture<SendResult<String,ProductDto>> future = kafkaTemplate.send("product-created-events-topic","wow i sent it",productDto);

        future.whenComplete((result,exception) -> {
            if(exception!=null){
                LOGGER.error("Failed to send message {}", exception.getMessage());
            }else{
                LOGGER.info("Message sent successfully {}", result.getRecordMetadata());
            }
        });

//        use below line when you want to block thread but if knowing is your criteria that message was
//        sent or not then don't block thread by below above will cover everything and above runs without blocking
//        future.join();

        LOGGER.info("Returning from Product Dto Controller /PostMapping");
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

}
