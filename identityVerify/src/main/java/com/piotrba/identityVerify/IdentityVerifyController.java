package com.piotrba.identityVerify;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify-check")
@AllArgsConstructor
public class IdentityVerifyController {

    private final IdentityVerifyService identityVerifyService;
    @GetMapping(path = "{userId}")
    public IdentityVerifyCheckResponse isFraudster
            (@PathVariable("userId") Long userId){
        boolean isfraudulentUser = identityVerifyService.isFraudulentUser(userId);
        return new IdentityVerifyCheckResponse(isfraudulentUser);
    }
}
