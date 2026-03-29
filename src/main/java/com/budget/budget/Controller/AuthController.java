package com.budget.budget.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget.Model.Client;
import com.budget.budget.Model.Influencer;
import com.budget.budget.Model.User;
import com.budget.budget.Repository.ClientRepository;
import com.budget.budget.Repository.InfluencerRepository;
import com.budget.budget.Repository.UserRepository;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InfluencerRepository influencerRepository;
    
    /*SIGN UP*/

    @PostMapping("/signup")
    public String signup(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "Email already exists";
        }

        if (!user.getPassword().equals(user.getConfirmpassword())) {
            return "Password and Confirm Password do not match";
        }

        userRepository.save(user);
        return "Signup Successfully";

    }

    /* LOG IN */

    @PostMapping("/login")
    public String login(User user) {
        
        User loginUser = userRepository.findByEmail(user.getEmail());

        if(loginUser == null){
            return "Please Signed up";
        }

        if (!loginUser.getPassword().equals(user.getPassword())) {
        return "Incorrect password";
        }

        return "Login Successfully";
    }


    /*Client Data */
    
    @PostMapping("/client")
    public String client(Client user) {

        User loginUser = userRepository.findByEmail(user.getEmail());

        if(loginUser == null){
            return "Please Signed up";
        }

        clientRepository.save(user);
        return "Registered Successfully";
    }

/*Influencer */

    @PostMapping("/influencer")
    public String influencer(Influencer user){
    
        User loginUser = userRepository.findByEmail(user.getEmail());

        if(loginUser == null){
            return "Please Signed up";
        }
        
        influencerRepository.save(user);
        return "Registered Successfully";
    }

}

