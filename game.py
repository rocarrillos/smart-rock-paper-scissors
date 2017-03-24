class Game(object):
    def __init__(self):
        """Initializes a Game object with two atributes. self.answer is an int 
        that will store the value of the player's entry, and self.cases is a 
        dict that stores the possible outcomes of the game."""
        self.computer_answer = int()
        self.answer = int()
        self.plays = {0: "Rock", 1: "Paper", 2: "Scissors"}
        self.cases = {(0, 1): "loss", (1, 2): "loss", (2, 0): "loss",
                        (1, 0): "win", (2, 1): "win", (0, 2): "win",
                        (0, 0): "tie", (1, 1): "tie", (2, 2): "tie"}

    def get_input(self):
        """ Asks for a string input from the player to get their move."""

        answer = str(input("Please choose rock, paper, or scissors: "))
        if answer == "rock" or answer == "r":
            self.answer = 0
        elif answer == "paper" or answer == "p":
            self.answer = 1
        elif answer == "scissors" or answer == "s":
            self.answer = 2
        else:
            print("That is not a valid input. Try again. ")
            self.get_input()

    def get_answer(self):
        return self.answer

    def get_computer_play(self):
        """This will be the most interesting thing to implement. 
        For now it will return 0 for Rock; eventually we will have it 
        analyze the best move and return that."""
        self.computer_answer = 0
        return self.computer_answer

    def get_cases(self):
        return self.cases.copy

    def get_result(self):
        """ Returns if the game resulted in a win, loss, or tie for the player.
        Rock corresponds to 0, Paper to 1, and Scissors to 2."""
        c = self.get_computer_play()
        print("You played", self.plays[self.answer])
        print("The machine played", c)
        print("Result is a", self.cases[(self.get_answer(), c)])
        return self.cases[(self.get_answer(), c)]


# test case
g = Game()
f = g.get_input()
print(g.get_result())
        