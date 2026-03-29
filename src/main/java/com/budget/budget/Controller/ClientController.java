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

import com.budget.budget.Model.Client;
import com.budget.budget.Repository.ClientRepository;

@RestController
@RequestMapping("/api/client")
@CrossOrigin
public class ClientController {
    
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/save")
    public String saveUser(Client u) { 
        clientRepository.save(u);
        return "Saved Successfully";
    }
    @GetMapping("/all")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
