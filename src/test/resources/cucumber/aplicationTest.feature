Feature: Gmail Testing

  Background: A Gmail

  Scenario: Gmail Login
    Given gmail open url
    Then fill the user login
    And fill the password
    Then click on Login

  Scenario: Compose Email
    Given user logged in
    Then click on Compose button
    And fill email for sending
    And fill subject content
    And fill text message
    Then click to Send

    Scenario: Delete Message
      Given user logged in
      Then click OnAllSentMessagesButton
      And  select LastSentMessage
      And  delete message
      Then confirm MessageDeleting
