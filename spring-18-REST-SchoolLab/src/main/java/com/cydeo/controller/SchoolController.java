package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {
        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved.",
                        studentService.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "Parents are successfully retrieved.",
                 HttpStatus.ACCEPTED.value(), parentService.findAll());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Parent", "Returned")
                .body(responseWrapper);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> readAddressById(@PathVariable Long id) throws Exception {
        ResponseWrapper responseWrapper = new ResponseWrapper("Address " + id + " is successfully retrieved", addressService.findById(id));
        return ResponseEntity.ok(responseWrapper);
    }

    /*
    create en endpoint to update individual address information.
    return updated address directly
     */

    @PutMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> updateAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);
        return ResponseEntity.ok(new ResponseWrapper("Address updated", addressService.update(addressDTO)));
    }



    // b1cf7afe3c2828d0cf3edb3692cd8c8c --> access key

}
