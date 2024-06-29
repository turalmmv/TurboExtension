package az.turbo.turboextension.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponseDto {

    private Long id;

    private String city;
    private String mark;
    private String model;
    private String graduationYear;
    private String banType;
    private String color;
    private String engine;
    private String odometer;
    private String gearbox;
    private String transmitter;
    private String isItNew;
    private String numberOfOwners;
    private String numberOfSeats;
    private String situation;
    private String region;


    private Boolean credit;
    private Boolean barter;
//    private Boolean isItAnAccident;

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

}
