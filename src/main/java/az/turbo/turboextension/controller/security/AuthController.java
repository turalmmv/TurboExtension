package az.turbo.turboextension.controller.security;

//import az.turbo.turboextension.dtos.request.ConfirmRequestDto;
import az.turbo.turboextension.dtos.request.ConfirmRequestDto;
import az.turbo.turboextension.dtos.security.request.AuthRequestDTO;
import az.turbo.turboextension.dtos.security.request.RegisterRequestDTO;
import az.turbo.turboextension.dtos.security.response.AuthResponseDTO;
import az.turbo.turboextension.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO dto) {
        return ResponseEntity.ok(authService.authenticate(dto));
    }

    @PostMapping("/confirm-email")
    public String confirm(@RequestBody ConfirmRequestDto dto) {
        return authService.confirm(dto);
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        boolean exists = authService.checkEmailExists(email);
        return ResponseEntity.ok(exists);
    }
}
