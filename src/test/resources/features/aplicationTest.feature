Feature: Gmail Testing

    Scenario: Compose email, and delete last sent email
      Given I'm on home page:https://mail.google.com
      When  login with credentials: papai9919@gmail.com,123456Pp
      Then Compose email for whom: superPapai1488@gmail.com, subject:subject, message: textMessage
      And Delete sent message