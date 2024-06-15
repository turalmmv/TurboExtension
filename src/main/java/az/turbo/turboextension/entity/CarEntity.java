package az.turbo.turboextension.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cars")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "city")
    private String city;
    @Column(name = "milegae")
    private String mileage;
    @Column(name = "graduationYear")
    private String graduationYear;
    @Column(name = "typeOfBan")
    private String typeOfBan;
    @Column(name = "color")
    private String color;
    @Column(name = "numberOfSeats")
    private String numberOfSeats;
    @Column(name = "engine")
    private String engine;
    @Column(name = "gearbox")
    private String gearbox;
    @Column(name = "situation")
    private String situation;
    @Column(name = "transmitter")
    private String transmitter;
    @Column(name = "isItNew")
    private Boolean isItNew;
    @Column(name = "numberOfOwners")
    private Integer numberOfOwners;
    @Column(name = "credit")
    private Boolean credit;
    @Column(name = "barter")
    private Boolean barter;
    @Column(name = "isItAnAccident")
    private Boolean isItAnAccident;
    @Column(name = "alloyWheels")
    private Boolean alloyWheels;
    @Column(name = "abs")
    private Boolean abs;
    @Column(name = "hatch")
    private Boolean hatch;
    @Column(name = "rainSensor")
    private Boolean rainSensor;
    @Column(name = "centralLocking")
    private Boolean centralLocking;
    @Column(name = "parkRadar")
    private Boolean parkRadar;
    @Column(name = "airConditioning")
    private Boolean airConditioning;
    @Column(name = "seatHeating")
    private Boolean seatHeating;
    @Column(name = "leatherSalon")
    private Boolean leatherSalon;
    @Column(name = "xenonLamps")
    private Boolean xenonLamps;
    @Column(name = "rearViewCamera")
    private Boolean rearViewCamera;
    @Column(name = "sideCurtains")
    private Boolean sideCurtains;
    @Column(name = "seatVentilation")
    private Boolean seatVentilation;


    @ManyToMany(mappedBy = "carEntities")
    List<CustomerEntity> customerEntities;

}
