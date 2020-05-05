package dachuk.snow.service.impl;

import dachuk.snow.model.User;
import dachuk.snow.repository.UserRepository;
import dachuk.snow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) {
        User findUser = userRepository.findByUsername(user.getUsername());
        if(findUser!=null){
            if(findUser.getPassword().equals(passwordEncoder.encode(user.getPassword()))){
                return user;
            }
        }
        return null;
    }

    @Override
    public User registration(User user) {
        User findUser = userRepository.findByUsername(user.getUsername());
        if(findUser==null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User approveStatus(User user) {
        user.setStatus("ACTIVE");
        return update(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public ArrayList<User> findAll() {
        return (ArrayList<User>) userRepository.findAll();
    }
}
