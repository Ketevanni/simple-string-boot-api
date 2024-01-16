package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping("/add-with-city/{cityId}")
    public ResponseEntity<Address> addAddressWithCity(@RequestBody Address address, @PathVariable Long cityId) {
        Address savedAddress = addressService.addAddress(address, cityId);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

}