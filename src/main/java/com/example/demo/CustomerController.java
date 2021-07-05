package com.example.demo;/**
 * Created by TUTEHUB on 2021/7/2 6:10 PM.
 * Copyright © 2021 TUTEHUB. All rights reserved.
 * ------------------------
 * Non-disclosure Terms
 * -------------------------
 * These codes are TUTEHUB's property, as the developer, such as employee, contractor, and intern, working for TUTEHUB cannot disclose, spread, copy, preserve, sell, and do other activities without the consent of TUTEHUB.
 * Developer dph agrees with above terms.
 * Technique Support: jobyme88.com
 * Contact: noreply@fengcaoculture.com
 */


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @description
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    public CustomerServiceImpl customerService;
    private ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customerCreated = customerService.createCustomer(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customerCreated.getId())
                .toUri();
        System.out.println(location);
        return ResponseEntity.created(location).build();
    }


    @GetMapping()
    public List<Customer> all() {
        return customerService.getAllCustomers();
    }


    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id,
                                                   @RequestBody JsonPatch patch) {
        try {
            Customer customer = customerService.findCustomer(id).orElseThrow(CustomerNotFoundException::new);
            Customer customerPatched = applyPatchToCustomer(patch, customer);
            customerService.updateCustomer(customer, customerPatched);

            return ResponseEntity.ok(customerPatched);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private Customer applyPatchToCustomer(JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
        Customer patchedCustomer = objectMapper.treeToValue(patched, Customer.class);
        return patchedCustomer;
    }

}
