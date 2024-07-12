package myapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("/shop")
    public ResponseEntity<?> getInfo() {
        return new ResponseEntity<String> ("info", HttpStatus.OK);
    }
    @GetMapping("/orders")
    public ResponseEntity<?> getUserInfo() {
        return new ResponseEntity<String> ("sales info", HttpStatus.OK);
    }
    @GetMapping("/payments")
    public ResponseEntity<?> getAdminInfo() {
        return new ResponseEntity<String> ("finance info", HttpStatus.OK);
    }
}


