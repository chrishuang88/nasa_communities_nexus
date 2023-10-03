package com.environlink.nassa;
import com.environlink.nassa.entity.User;
import com.environlink.nassa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String getText(){
        return "Succesffuly !!!";
    }

    @GetMapping("count-users")
    public String getCountUsers(){
        long numberUsers = userRepository.count();
        return "Number of users = "+numberUsers;
    }

    @GetMapping("add-user")
    public String addUser(){
        User user = new User();
        user.setFirstName("Render");
        user.setLastName("Spring Boot");
        userRepository.save(user);
        return "User added successfully good..";
    }

}