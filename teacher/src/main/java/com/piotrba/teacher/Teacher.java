package com.piotrba.teacher;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher{

    @Id
    @SequenceGenerator(name = "teacher_id_sequence", sequenceName = "teacher_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
}
