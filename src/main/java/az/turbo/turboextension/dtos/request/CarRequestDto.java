package az.turbo.turboextension.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarRequestDto {

    private String city;
    private String mileage;
    private String graduationYear;
    private String typeOfBan;
    private String color;
    private String numberOfSeats;
    private String engine;
    private String gearbox;
    private String situation;
    private String transmitter;
    private Boolean isItNew;
    private Integer numberOfOwners;
    private Boolean credit;
    private Boolean barter;
    private Boolean isItAnAccident;
    private Boolean alloyWheels;
    private Boolean abs;
    private Boolean hatch;
    private Boolean rainSensor;
    private Boolean centralLocking;
    private Boolean parkRadar;
    private Boolean airConditioning;
    private Boolean seatHeating;
    private Boolean leatherSalon;
    private Boolean xenonLamps;
    private Boolean rearViewCamera;
    private Boolean sideCurtains;
    private Boolean seatVentilation;

    private List<Long> customerId;

}
