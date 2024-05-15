package com.piotrba.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public void registerStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest){
        log.info("new customer registration {}", studentRegistrationRequest);
        studentService.registerStudent(studentRegistrationRequest);
    }
}