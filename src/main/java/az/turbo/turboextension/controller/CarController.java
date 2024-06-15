package az.turbo.turboextension.controller;

import az.turbo.turboextension.dtos.request.CarRequestDto;
import az.turbo.turboextension.dtos.response.CarResponseDto;
import az.turbo.turboextension.service.CarService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@Data
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

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long id) {
        carService.delete(id);
    }
}
