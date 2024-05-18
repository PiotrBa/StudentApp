package com.piotrba.teacher;

public record TeacherRegistrationRequest(String firstName, String lastName, String email, UserType userType) {
}
