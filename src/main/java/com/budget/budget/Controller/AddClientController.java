package com.budget.budget.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget.Model.AddClient;
import com.budget.budget.Repository.AddClientRepository;

@RestController
@RequestMapping("/api/addclient")
@CrossOrigin(origins = "*")
public class AddClientController {

    @Autowired
    private AddClientRepository addClientRepository;

    @PostMapping("/save")
    public String saveUser(AddClient u) { 
        addClientRepository.save(u);
        return "Client Added Successfully";
    }

    @GetMapping("/all")
    public List<AddClient> getAllClients(){
        return addClientRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddClient> updateClient(@PathVariable Long id, @RequestBody AddClient updatedClient) {

        System.out.println(updatedClient.getName()); 
        Optional<AddClient> clientOpt = addClientRepository.findById(id);

        if(clientOpt.isPresent()){
            AddClient client = clientOpt.get();

            client.setName(updatedClient.getName());
            client.setCity(updatedClient.getCity());
            client.setState(updatedClient.getState());
            client.setBrand(updatedClient.getBrand());
            client.setProduct(updatedClient.getProduct());

            addClientRepository.save(client);

            return ResponseEntity.ok(client);
        }

        return ResponseEntity.notFound().build();
    }
}