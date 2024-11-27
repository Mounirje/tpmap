package org.example.modelmapperdemo;

import lombok.AllArgsConstructor;
import org.example.modelmapperdemo.dtos.CustomerDTO;
import org.example.modelmapperdemo.dtos.CustomerDtoNew;
import org.example.modelmapperdemo.entities.Customer;
import org.example.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication @AllArgsConstructor
public class ModelMapperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }
    @Bean
    CommandLineRunner start(){
        return args -> {
            CustomerMapper customerMapper = new CustomerMapper();
          Customer c1 = Customer.builder()
                  .email("c1@gmail.com")
                  .name("John Doe")
                  .password("123456")
                  .build();
          Customer c2 = Customer.builder()
                  .email("c2@gmail.com")
                  .name("John Aziz")
                  .password("123456")
                  .build();
          Customer c3 = Customer.builder()
                  .email("c2@gmail.com")
                  .name("Zri9a L3ssas")
                  .password("123456")
                  .build();
          List<Customer> customerList = new ArrayList<>();
          customerList.add(c1);
          customerList.add(c2);
          customerList.add(c3);
          List<CustomerDTO> customerDTOList = customerList.stream().map(customerMapper::fromCustomer).toList();
          System.out.println(customerDTOList);

          List<CustomerDtoNew> customerDTONewList = customerList.stream().map(customerMapper::fromCustomerNew).toList();
          System.out.println(customerDTONewList);



        };

    }

}
