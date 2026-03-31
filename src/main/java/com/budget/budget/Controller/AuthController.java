package com.budget.budget.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget.Model.Client;
import com.budget.budget.Model.Influencer;
import com.budget.budget.Model.User;
import com.budget.budget.Repository.ClientRepository;
import com.budget.budget.Repository.InfluencerRepository;
import com.budget.budget.Repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // allows requests from any origin (Netlify frontend)
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InfluencerRepository influencerRepository;

    /* SIGNUP */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            return ResponseEntity.status(400)
                    .body(Map.of("success", false, "message", "Email already exists"));
        }

        if (!user.getPassword().equals(user.getConfirmpassword())) {
            return ResponseEntity.status(400)
                    .body(Map.of("success", false, "message", "Password and Confirm Password do not match"));
        }

        userRepository.save(user);
        return ResponseEntity.ok(Map.of("success", true, "message", "Signup successful"));
    }

    /* LOGIN */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User loginUser = userRepository.findByEmail(user.getEmail());

        if (loginUser == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("success", false, "message", "Please sign up first"));
        }

        if (!loginUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401)
                    .body(Map.of("success", false, "message", "Incorrect password"));
        }

        return ResponseEntity.ok(Map.of("success", true, "message", "Login successful"));
    }

    /* CLIENT DATA */
    @PostMapping("/client")
    public ResponseEntity<?> client(@RequestBody Client client) {

        User loginUser = userRepository.findByEmail(client.getEmail());
        if (loginUser == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("success", false, "message", "Please sign up first"));
        }

        clientRepository.save(client);
        return ResponseEntity.ok(Map.of("success", true, "message", "Client registered successfully"));
    }

    /* INFLUENCER DATA */
    @PostMapping("/influencer")
    public ResponseEntity<?> influencer(@RequestBody Influencer influencer) {

        User loginUser = userRepository.findByEmail(influencer.getEmail());
        if (loginUser == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("success", false, "message", "Please sign up first"));
        }

        influencerRepository.save(influencer);
        return ResponseEntity.ok(Map.of("success", true, "message", "Influencer registered successfully"));
    }

}

