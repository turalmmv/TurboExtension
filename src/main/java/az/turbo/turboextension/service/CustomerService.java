package az.turbo.turboextension.service;

import az.turbo.turboextension.dtos.request.CustomerRequestDto;
import az.turbo.turboextension.dtos.response.CustomerResponseDto;
import az.turbo.turboextension.entity.CarEntity;
import az.turbo.turboextension.entity.CustomerEntity;
import az.turbo.turboextension.repository.CarRepository;
import az.turbo.turboextension.repository.CustomerRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        CustomerEntity customerEntity = mapDtoToEntity(customerRequestDto);
        customerRepository.save(customerEntity);
    }


    public List<CustomerResponseDto> read(){
        List<CustomerResponseDto> responseDtos = new ArrayList<>();
        List<CustomerEntity> all = customerRepository.findAll();
        for (CustomerEntity customerEntity : all) {
            List<CarEntity> cars = carRepository.findAllByCustomerId(customerEntity.getId());
            CustomerResponseDto map = modelMapper.map(customerEntity, CustomerResponseDto.class);
            map.setCarEntity(cars);
            responseDtos.add(map);
        }
        return responseDtos;
    }


    public void update(){
        //configure scheduler
    }

    public void delete(Long id){
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerEntity);
    }

    public CustomerEntity mapDtoToEntity(CustomerRequestDto customerRequestDto){
        return CustomerEntity.builder()
                .email(customerRequestDto.getEmail())
                .name(customerRequestDto.getName())
                .password(customerRequestDto.getPassword())
                .build();
    }




}
