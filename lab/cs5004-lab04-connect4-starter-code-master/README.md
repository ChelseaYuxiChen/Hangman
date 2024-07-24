# Lab 4: Connect Four Game Model

This repository contains the model for the Connect Four game, which is part of the CS 5004 Object-Oriented Design course. This is the fourth lab assignment in the series.

## Project Overview

The Connect Four game is a classic two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the lowest available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs.

In this lab, we focus on creating the model for the game. The model is responsible for maintaining the state of the game and the rules. It includes the following features:

- Initializing the game board
- Making a move
- Checking if the game is over
- Identifying the winner
- Resetting the board

## Code Structure

The main classes in this project are:

- `ConnectFourModel`: This is the interface that defines the operations that must be supported by the Connect Four game model.
- `ConnectFourModelImpl`: This is the class you need to write. It implements the `ConnectFourModel` interface and provides the functionality for the Connect Four game model. The traditional game board has six rows and seven columns. However, we want to build a more flexible game so your constructor must take the number of rows and columns on the board as parameters.
- `Player`: This is an enumeration that represents the two players in the game, RED and YELLOW.

## Unit Tests

You need to write a comprehensive set of unit tests. These tests must cover various scenarios including making valid and invalid moves, checking the game state, and identifying the winner. Think carefully about all the edge cases that need to be tested.
## Future Work

The upcoming labs will focus on developing the controller and the view for the Connect Four game. The controller will handle the game logic and the view will be responsible for the user interface.

## Contributing

This project is part of a course assignment and is not open for contributions.