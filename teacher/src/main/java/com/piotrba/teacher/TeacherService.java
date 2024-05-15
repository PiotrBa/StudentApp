package com.piotrba.teacher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final RestTemplate restTemplate;

    public void registerTeacher(TeacherRegistrationRequest request){
        Teacher teacher = Teacher.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        teacherRepository.saveAndFlush(teacher);

        String url = "http://localhost:8081/verify-check/" + teacher.getId();
        IdentityVerifyCheckTeacherResponse checkTeacherResponse = restTemplate.getForObject(url, IdentityVerifyCheckTeacherResponse.class);
        if (checkTeacherResponse.isfraudulentUser()){
            throw new IllegalStateException("fraudster");
        }
    }
}
