package com.piotrba.identityVerify;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class IdentityVerifyService {

    private final IdentityVerifyRepository identityVerifyRepository;

    public boolean isFraudulentUser(Long customerId){
        identityVerifyRepository.save(IdentityVerifyHistory.builder()
                        .userId(customerId)
                        .isFraudster(false)
                        .created(LocalDateTime.now())
                .build());
        return false;
    }
}
