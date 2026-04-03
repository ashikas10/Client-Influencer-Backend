package com.budget.budget.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget.Model.AddInfluencer;
import com.budget.budget.Repository.AddInfluencerRepository;


@RestController
@RequestMapping("/api/addinfluencer")
@CrossOrigin(origins = "*")
public class AddInfluencerController {
    
    @Autowired
    private AddInfluencerRepository addInfluencerRepository;

    @PostMapping("/save")
    public String saveUser(@ModelAttribute AddInfluencer u) {
        addInfluencerRepository.save(u);
        return "Influencer Added Successfully";
    }
    @GetMapping("/all")
    public List<AddInfluencer> getAllInfluencers(){
        return addInfluencerRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddInfluencer> updateInfluencer(@PathVariable Long id, @RequestBody AddInfluencer updatedInfluencer) {

        System.out.println(updatedInfluencer.getName()); 
        Optional<AddInfluencer> InfluencerOpt = addInfluencerRepository.findById(id);

        if(InfluencerOpt.isPresent()){
            AddInfluencer influencer = InfluencerOpt.get();

            influencer.setName(updatedInfluencer.getName());
            influencer.setCity(updatedInfluencer.getCity());
            influencer.setState(updatedInfluencer.getState());
            influencer.setInstaUserName(updatedInfluencer.getInstaUserName());
            influencer.setBudget(updatedInfluencer.getBudget());
            influencer.setProduct(updatedInfluencer.getProduct());
            addInfluencerRepository.save(influencer);
            return ResponseEntity.ok(influencer);
        }

        return ResponseEntity.notFound().build();
    }
}
