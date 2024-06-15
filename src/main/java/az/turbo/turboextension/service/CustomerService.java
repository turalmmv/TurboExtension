package az.turbo.turboextension.service;

import az.turbo.turboextension.dtos.request.CustomerRequestDto;
import az.turbo.turboextension.dtos.response.CustomerResponseDto;
import az.turbo.turboextension.entity.CustomerEntity;
import az.turbo.turboextension.repository.CarRepository;
import az.turbo.turboextension.repository.CustomerRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;


    //Crud
    public void create(CustomerRequestDto customerRequestDto){
        CustomerEntity customer = modelMapper.map(customerRequestDto, CustomerEntity.class);
        customerRepository.save(customer);
    }

    public List<CustomerResponseDto> read(){
        List<CustomerEntity> all = customerRepository.findAll();
        return all.stream()
                .map(customerEntity -> modelMapper.map(customerEntity, CustomerResponseDto.class))
                .collect(Collectors.toList());
    }


    public void update(){
        //configure scheduler
    }

    public void delete(Long id){
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerEntity);
    }




}
