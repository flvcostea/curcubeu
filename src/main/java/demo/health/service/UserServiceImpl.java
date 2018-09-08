package demo.health.service;

import demo.health.model.Person;
import demo.health.model.User;
import demo.health.repository.PersonRepository;
import demo.health.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;
    @Qualifier("personRepository")
    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional
    public String addUser(User user) {
        if (user != null && verifyIfExists(user)== null ) {

            User newUser=userRepository.save(user);



        } else {
            return "Entry was not saved.";
        }
        return "Succesfully saved!";
    }


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByEmail(String emailAddress) {
        for (User u : userRepository.findAll()) {
            if (u.getEmail().equals(emailAddress))
                return u;
        }
        return null;
    }

    @Override
    public User updateUser(int id, User user) {

        User updatedUser = findById(id);
        Person person = personRepository.getOne(updatedUser.getPerson().getId());

        if (user.getUsername()!=null) updatedUser.setUsername(user.getUsername());
        if (user.getEmail()!=null) updatedUser.setEmail(user.getEmail());
        if (user.getDescription()!=null)updatedUser.setDescription(user.getDescription());
        if (user.getImage()!=null)updatedUser.setImage(user.getImage());
        if (user.getPassword()!=null)updatedUser.setPassword(user.getPassword());

        //person.setUser(updatedUser);

        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(int id) {

        User user = userRepository.getOne(id);   //se incarca in user intrarea obtinuta dupa cautarea dupa id in users

        personRepository.delete(user.getPerson());   //in persons, se sterge persoana


        userRepository.delete(user);
    }
    @Override
    public User loginUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User u = userRepository.login(email, password);

        return u;
    }

    @Override
    public User verifyIfExists(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User u = userRepository.verifyIfExists(email, password);

        return u;
    }


}
