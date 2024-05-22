package com.piotrba.teacher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@AllArgsConstructor
public class TeacherService{

    private final TeacherRepository teacherRepository;
    private final RestTemplate restTemplate;


    public void registerTeacher(TeacherRegistrationRequest request){
        Teacher teacher = Teacher.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .userType(UserType.TEACHER)
                .build();
        teacherRepository.saveAndFlush(teacher);

        String urlTemplate = "http://localhost:8081/verify-check/{userId}";
        String url = UriComponentsBuilder.fromUriString(urlTemplate)
                .queryParam("userType", teacher.getUserType().toString())
                .buildAndExpand(teacher.getId())
                .toUriString();

        IdentityVerifyCheckTeacherResponse checkTeacherResponse = restTemplate.getForObject(url, IdentityVerifyCheckTeacherResponse.class);
        if (checkTeacherResponse.isfraudulentUser()){
            throw new IllegalStateException("fraudster");
        }
    }
}
