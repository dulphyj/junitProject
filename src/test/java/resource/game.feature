Feature: Game Rock, Paper or Scissors

  Scenario: The user wins when chooses Rock and computer chooses Scissors
    Given the user will choose "Rock"
    And the computer will choose "Scissors"
    When they play
    Then verify that the computer chose "scissors"
    And the user wins

  Scenario: The user wins when chooses Scissors and computer chooses Paper
    Given the user will choose "Scissors"
    And the computer will choose "Paper"
    When they play
    Then verify that the computer chose "paper"
    And the user wins

  Scenario: The user wins when chooses Paper and computer chooses Rock
    Given the user will choose "Paper"
    And the computer will choose "Rock"
    When they play
    Then verify that the computer chose "rock"
    And the user wins

  Scenario: The user loses when chooses Paper and computer chooses Scissors
    Given the user will choose "Paper"
    And the computer will choose "Scissors"
    When they play
    Then verify that the computer chose "scissors"
    And the user lose

  Scenario: The user tie when chooses Paper and computer chooses Paper
    Given the user will choose "Paper"
    And the computer will choose "Paper"
    When they play
    Then verify that the computer chose "paper"
    And the user tie