package org.example.modelmapperdemo.mappers;

import org.example.modelmapperdemo.dtos.CustomerDTO;
import org.example.modelmapperdemo.dtos.CustomerDtoNew;
import org.example.modelmapperdemo.entities.Customer;
import org.modelmapper.ModelMapper;

public class CustomerMapper {
    private ModelMapper modelMapper = new ModelMapper();
    public CustomerDTO fromCustomer(Customer customer) {
        return this.modelMapper.map(customer, CustomerDTO.class);
    }
    public CustomerDtoNew fromCustomerNew(Customer customer) {
        return this.modelMapper.map(customer, CustomerDtoNew.class);
    }

}
