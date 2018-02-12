Feature: Gmail Testing

  Scenario: Gmail Login
    Given gmail open url: https://mail.google.com
    When fill the user login: papai9919@gmail.com
    And fill the password: 123456Pp
    Then click on Login

  Scenario: Compose Email
    Given click on Compose button
    When fill email for sending: superPapai1488@gmail.com
    When fill subject content: subject
    And fill text message: textMessage
    Then click to Send

  Scenario: Delete Message
    When click OnAllSentMessagesButton
    Then  select LastSentMessage
    And  delete message
    Then confirm MessageDeleting