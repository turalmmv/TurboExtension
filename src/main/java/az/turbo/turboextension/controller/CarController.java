package az.turbo.turboextension.controller;

import az.turbo.turboextension.dtos.request.CarRequestDto;
import az.turbo.turboextension.dtos.response.CarResponseDto;
import az.turbo.turboextension.entity.CarEntity;
import az.turbo.turboextension.service.CarService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/car")
@Data
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {
    private final CarService carService;

    @PostMapping("/create")
    public void create(@RequestBody CarRequestDto carRequestDto) {
        carService.create(carRequestDto);
    }

    @GetMapping("/get-all")
    public List<CarResponseDto> read() {
        return carService.read();
    }

    @PutMapping("/update")
    public void update() {
        //configure scheduler
    }

    @GetMapping("/byIds")
    public List<CarEntity> getCarsByIds(@RequestParam List<Long> ids) {
        return carService.getCarsByIds(ids);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long id) {
        carService.delete(id);
    }


//    @PostMapping("/save-car")
//    public String read(@RequestParam String path) throws IOException {
//        jsoupService.startPoint();
//        return "Succes";
//    }
}
