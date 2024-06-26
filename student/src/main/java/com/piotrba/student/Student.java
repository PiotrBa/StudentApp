package com.piotrba.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
