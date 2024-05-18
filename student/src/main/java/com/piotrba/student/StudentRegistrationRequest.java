package com.piotrba.student;

public record StudentRegistrationRequest(String firstName, String lastName, String email, UserType userType) {

}
