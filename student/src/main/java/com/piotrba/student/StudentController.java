package com.piotrba.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@Slf4j
public record StudentController(StudentService studentService) {

    @PostMapping
    public void registerStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest){
        log.info("new customer registration {}", studentRegistrationRequest);
        studentService.registerStudent(studentRegistrationRequest);
    }
}