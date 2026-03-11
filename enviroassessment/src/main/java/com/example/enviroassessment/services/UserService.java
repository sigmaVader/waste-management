package com.example.enviroassessment.services;

import com.example.enviroassessment.dto.UserDto;
import com.example.enviroassessment.entities.User;
import com.example.enviroassessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;




    //Convert the entity to a dto
    private UserDto convertToDto(User user){

        UserDto  userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmailAddress(user.getEmail());
        userDto.setPassword(user.getPassword());


        return  userDto;
    }


    //CREATIONG OF USERS
    public String RegisterUser(UserDto userDto){


        System.out.println("Inside RegisterUser");

         // to avoid creating user with the same email
        if(userRepository.findByEmail(userDto.getEmailAddress()).isPresent()){
            return "Email already exists";
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmailAddress());

        //hashing passowrd
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);


       return "User Successfully registered";
    }





    public UserDto findByEmail(String email){

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return convertToDto(user);
    }

    public UserDto login(String email, String password) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return null;
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }

        return convertToDto(user);
    }




}
