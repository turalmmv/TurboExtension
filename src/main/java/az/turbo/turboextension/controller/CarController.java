package az.turbo.turboextension.controller;

import az.turbo.turboextension.dtos.request.CarRequestDto;
import az.turbo.turboextension.dtos.response.CarResponseDto;
import az.turbo.turboextension.service.CarService;
import az.turbo.turboextension.service.JsoupService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/car")
@Data
public class CarController {
    private final CarService carService;
    private final JsoupService jsoupService;

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


//    @PostMapping("/save-car")
//    public String read(@RequestParam String path) throws IOException {
//        jsoupService.startPoint();
//        return "Succes";
//    }
}
