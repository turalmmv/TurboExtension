package az.turbo.turboextension.service;

import az.turbo.turboextension.dtos.request.CarRequestDto;
import az.turbo.turboextension.dtos.response.CarResponseDto;
import az.turbo.turboextension.entity.CarEntity;
import az.turbo.turboextension.entity.CustomerEntity;
import az.turbo.turboextension.repository.CarRepository;
import az.turbo.turboextension.repository.CustomerRepository;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CarService {
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;


    //CRUD
    public void create(CarRequestDto carRequestDto){
        CarEntity carEntity = modelMapper.map(carRequestDto, CarEntity.class);
        List<CustomerEntity> customerEntities = customerRepository.findAllById(carRequestDto.getCustomerId());
        carEntity.setCustomerEntities(customerEntities);

        carRepository.save(carEntity);
    }

    public List<CarResponseDto> read(){
        List<CarEntity> all = carRepository.findAll();
        return all.stream()
                .map(carEntity -> modelMapper.map(carEntity, CarResponseDto.class))
                .collect(Collectors.toList());
    }

    public void update(){
        //configure scheduler
    }


    public void delete(Long id){
        CarEntity carEntity = carRepository.findById(id).orElseThrow();
        carRepository.delete(carEntity);
    }
}
