# Verify Kiwisaver Calculator Current Age Information

As a Product Owner
I want that while using the KiwiSaver Retirement Calculator all fields in the calculator have got
the information icon present
So that
The user is able to get a clear understanding of what needs to be entered in the field .

## Acceptance Criteria
* Scenario 1
  Given User Clicks information icon besides Current age the message “This calculator has an age
  limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.” is displayed below
  the current age field.

## [Kiwisaver Calculator Current Age Information](-)
Given I have opened the Westpac KiwiSaver Calculator Page
When I click on the Current Age Information Icon
Then I will be displayed Information stating [This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.](- "?=currentAgeInformation()")