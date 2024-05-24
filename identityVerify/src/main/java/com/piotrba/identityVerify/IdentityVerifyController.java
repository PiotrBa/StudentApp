package com.piotrba.identityVerify;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify-check")
@AllArgsConstructor
@Slf4j
public class IdentityVerifyController {

    private final IdentityVerifyService identityVerifyService;
    @GetMapping(path = "{userId}")
    public IdentityVerifyCheckResponse isFraudster
            (@PathVariable("userId") Long userId, @RequestParam("userType") UserType userType){
        boolean isfraudulentUser = identityVerifyService.isFraudulentUser(userId, userType);
        log.info("Fraud check request for user {}, type{}", userId, userType);
        return new IdentityVerifyCheckResponse(isfraudulentUser);
    }
}
