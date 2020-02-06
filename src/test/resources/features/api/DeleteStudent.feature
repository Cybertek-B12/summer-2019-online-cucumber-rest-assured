@api @delete_student
Feature: Delete student

  Scenario: 1. Delete student as a teacher and verify status code 204
    Given authorization token is provided for "teacher"
    And user accepts content type as "application/json"
    When user sends DELETE request to "/api/students/5739"
    And user verifies that response status code is 204