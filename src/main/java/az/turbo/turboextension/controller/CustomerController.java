package az.turbo.turboextension.controller;

import az.turbo.turboextension.dtos.request.CustomerRequestDto;
import az.turbo.turboextension.dtos.response.CustomerResponseDto;
import az.turbo.turboextension.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@Data
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public void create(@RequestBody CustomerRequestDto customerRequestDto) {
        customerService.create(customerRequestDto);
    }

    @GetMapping("/get-all")
    public List<CustomerResponseDto> read() {
        return customerService.read();
    }


    @PutMapping("/update")
    public void update() {
        //configure scheduler
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long id) {
        customerService.delete(id);
    }
}
