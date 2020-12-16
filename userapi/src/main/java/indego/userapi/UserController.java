package indego.userapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUser(){
        userRepository.findAll().forEach(user->System.out.println(user.getLastName()));
        return userRepository.findAll();
    }

    @GetMapping("/userssortedbyfirstname")
    public List<User> getAllUserSortedByFirstName(){
        userRepository.findAll().forEach(user->System.out.println(user.getLastName()));
        return userRepository.findAll().stream().sorted((a,b) -> a.getFirstName().compareTo(b.getFirstName())).collect(Collectors.toList());
    }

    @GetMapping("/userssortedbylastname")
    public List<User> getAllUserSortedByLastName(){
        userRepository.findAll().forEach(user->System.out.println(user.getLastName()));
        return userRepository.findAll().stream().sorted((a,b) -> a.getLastName().compareTo(b.getLastName())).collect(Collectors.toList());
    }

    @GetMapping("/userssortedbyemail")
    public List<User> getAllUserSortedByEMail(){
        userRepository.findAll().forEach(user->System.out.println(user.getLastName()));
        return userRepository.findAll().stream().sorted((a,b) -> a.getEMail().compareTo(b.getEMail())).collect(Collectors.toList());
    }

    @GetMapping("/userssortedbyuserid")
    public List<User> getAllUserSortedByUserId(){
        userRepository.findAll().forEach(user->System.out.println(user.getLastName()));
        return userRepository.findAll().stream().sorted((a,b) -> a.getUserId().compareTo(b.getUserId())).collect(Collectors.toList());
    }

    @PostMapping("/users")
    public void createUser(User user){
        if(user.getFirstName()==null && user.getLastName()==null && user.getEMail()==null){
            user.setFirstName("empty");
            user.setLastName("empty");
            user.setEMail("needs@tobe.fixed");
        }
        userRepository.save(user);
        System.out.println("adding " +user.getUserId());
    }
}
