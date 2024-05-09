package com.piotrba.teacher;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@Slf4j
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public void registerTeacher(@RequestBody TeacherRegistrationRequest teacherRegistrationRequest){
        log.info("new teacher registration {}", teacherRegistrationRequest);
        teacherService.registerTeacher(teacherRegistrationRequest);
    }
}
