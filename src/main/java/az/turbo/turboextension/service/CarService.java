package az.turbo.turboextension.service;

import az.turbo.turboextension.dtos.request.CarRequestDto;
import az.turbo.turboextension.dtos.response.CarResponseDto;
import az.turbo.turboextension.entity.CarEntity;
import az.turbo.turboextension.repository.CarRepository;
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


    //CRUD
    public void create(CarRequestDto carRequestDto){
        CarEntity carEntity = mapDtoToEntity(carRequestDto);
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


    public List<CarEntity> getCarsByIds(List<Long> ids) {
        return carRepository.findAllById(ids);
    }


    public CarEntity mapDtoToEntity(CarRequestDto carRequestDto) {
        return CarEntity.builder()
                .abs(carRequestDto.getAbs())
                .city(carRequestDto.getCity())
                .mark(carRequestDto.getMark())
                .model(carRequestDto.getModel())
                .color(carRequestDto.getColor())
                .alloyWheels(carRequestDto.getAlloyWheels())
                .barter(carRequestDto.getBarter())
                .engine(carRequestDto.getEngine())
                .gearBox(carRequestDto.getGearBox())
                .hatch(carRequestDto.getHatch())
                .credit(carRequestDto.getCredit())
                .centralLocking(carRequestDto.getCentralLocking())
                .isItNew(carRequestDto.getIsItNew())
                .odometer(carRequestDto.getOdometer())
                .airConditioning(carRequestDto.getAirConditioning())
                .graduationYear(carRequestDto.getGraduationYear())
                .leatherSalon(carRequestDto.getLeatherSalon())
                .numberOfOwners(carRequestDto.getNumberOfOwners())
                .numberOfSeats(carRequestDto.getNumberOfSeats())
                .parkRadar(carRequestDto.getParkRadar())
                .rainSensor(carRequestDto.getRainSensor())
                .rearViewCamera(carRequestDto.getRearViewCamera())
                .seatHeating(carRequestDto.getSeatHeating())
                .seatVentilation(carRequestDto.getSeatVentilation())
                .sideCurtains(carRequestDto.getSideCurtains())
                .situation(carRequestDto.getSituation())
                .transmitter(carRequestDto.getTransmitter())
                .banType(carRequestDto.getBanType())
                .xenonLamps(carRequestDto.getXenonLamps())
                .region(carRequestDto.getRegion())
                .build();
    }
}
