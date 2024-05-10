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
    @GetMapping(path = "{customerId")
    public IdentityVerifyResponse isFraudster
            (@PathVariable("customerId") Long customerId){
        boolean isfraudulentUser = identityVerifyService.isFraudulentUser(customerId);
        return new IdentityVerifyResponse(isfraudulentUser);
    }
}
