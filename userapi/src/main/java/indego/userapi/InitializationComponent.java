package indego.userapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializationComponent {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {

        userRepository.deleteAll();

        User user = new User();
        user.setFirstName("Luke");
        user.setLastName("Skywalker");
        user.setEMail("luke@skywalker.com");
        userRepository.save(user);

        User user2 = new User();
        user2.setFirstName("Don");
        user2.setLastName("Joe");
        user2.setEMail("don@joe.com");
        userRepository.save(user2);

        User user3 = new User();
        user3.setFirstName("Max");
        user3.setLastName("Mustermann");
        user3.setEMail("max@mustermann.de");
        userRepository.save(user3);
    }
}
