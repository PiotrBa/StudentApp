package com.piotrba.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
                .userType(UserType.STUDENT)
                .build();
        studentRepository.saveAndFlush(student);

        String urlTemplate = "http://localhost:8085/verify-check/{userId}";
        String url = UriComponentsBuilder.fromUriString(urlTemplate)
                .queryParam("userType", student.getUserType().toString())
                .buildAndExpand(student.getId())
                .toUriString();

        IdentityVerifyCheckStudentResponse checkStudentResponse = restTemplate.getForObject(url, IdentityVerifyCheckStudentResponse.class);
        if (checkStudentResponse.isfraudulentUser()){
            throw new IllegalStateException("fraudster");
        }
    }
}

