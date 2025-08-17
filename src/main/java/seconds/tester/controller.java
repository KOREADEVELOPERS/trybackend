package seconds.tester;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Frontend host ke liye CORS allow
public class controller {

    private final userrepository userRepository;

    public controller(userrepository userRepository) {
        this.userRepository = userRepository;
    }

    // Registration endpoint
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if(existing.isPresent()) return "User already exists!";
        userRepository.save(user);
        return "Registration Successful!";
    }

    // Login endpoint
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if(existing.isPresent() && existing.get().getPassword().equals(user.getPassword())) {
            return "Login Successful!";
        } else {
            return "Invalid Credentials!";
        }
    }
}
