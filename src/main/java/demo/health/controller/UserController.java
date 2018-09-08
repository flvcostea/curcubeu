package demo.health.controller;


import demo.health.model.User;
import demo.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {

        return userService.addUser(user);
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll() {

        return userService.findAllUsers();

    }

    @RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
    public User userId(@PathVariable("id") int id) {
        return userService.findById(id);
    }


    @RequestMapping(value = "/userEmail/{emailAddress}", method = RequestMethod.GET)
    public User userEmail(@PathVariable("emailAddress") String emailAddress) {
        return userService.findByEmail(emailAddress);
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public User userUpdate(@PathVariable("id") int id, @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {

        return userService.loginUser(user);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

}



