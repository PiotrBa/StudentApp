package com.piotrba.identityVerify;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IdentityVerifyHistory {

    @Id
    @SequenceGenerator(name = "verify_id_sequence", sequenceName = "verify_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verify_id_sequence")
    private Long id;
    private Long customerId;
    private Boolean isFraudster;
    private LocalDateTime created;
}
