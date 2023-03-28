package live.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<user> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public user getUserById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping
    public user creatUser(@RequestBody user user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public user updateUser(@PathVariable Long id, @RequestBody user user){
        user existingUser = userRepository.findById(id).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);

    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        try {
            // find the user
            userRepository.findById(id).get();
            userRepository.deleteById(id);
            return "User deleted successfully";
        } catch (Exception e) {
            // TODO: handle exception
            return "User not found";
        }
    }
}
