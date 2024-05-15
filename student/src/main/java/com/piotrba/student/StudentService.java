package com.piotrba.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    public void registerStudent(StudentRegistrationRequest request){
        Student student = Student.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        studentRepository.saveAndFlush(student);

        String url = "http://localhost:8085/verify-check/" + student.getId();
        IdentityVerifyCheckStudentResponse checkStudentResponse = restTemplate.getForObject(url, IdentityVerifyCheckStudentResponse.class);
        if (checkStudentResponse.isfraudulentUser()){
            throw new IllegalStateException("fraudster");
        }
    }
}