package com.budget.budget.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget.Model.Influencer;
import com.budget.budget.Repository.InfluencerRepository;

@RestController
@RequestMapping("/api/influencer")
@CrossOrigin
public class InfluencerController {
    
    @Autowired
    private InfluencerRepository influenerRepository;

    @PostMapping("/save")
    public String saveUser(Influencer u) { 
        influenerRepository.save(u);
        return "Saved Successfully";
    }
    @GetMapping("/all")
    public List<Influencer> getAllInfluencers(){
        return influenerRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInfluencer(@PathVariable Long id){
        if(influenerRepository.existsById(id)){
            influenerRepository.deleteById(id);
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
