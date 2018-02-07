Feature: Gmail Testing

  Scenario: Gmail Login
    Given gmail open url
    When fill the user login
    And fill the password
    Then click on Login

  Scenario: Compose Email
    Given click on Compose button
    When fill email for sending
    When fill subject content
    And fill text message
    Then click to Send

  Scenario: Delete Message
    Given user logged in
    When click OnAllSentMessagesButton
    Then  select LastSentMessage
    And  delete message
    Then confirm MessageDeleting