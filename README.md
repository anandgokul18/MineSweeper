# MineSweeper

A MineSweeper Game

## Features

##### Uncovering a square. 
The player uncovers a square with a left-click on a button at that location. If it's non-mine location, what shows up at that square is the number of adjacent hidden mines (a number 1 - 8 because diagonals are considered adjacent). If there are no mines adjacent to this square, it displays no number. If the player uncovers a mine instead, it explodes, and they lose the game.

##### Automatic opening of empty regions. 
To make it less tedious for the user, when they open a square that has no adjacent mines, the game automatically opens all the squares in that region that aren't adjacent to mines until it gets to the boundary of the field, or squares that are adjacent to other mines. Here is an example that illustrates the effect:

##### Guessing a mine location. 
Based on the opened squares, if the player can then deduce the location of a mine, they can mark that unopened location as a mine-guess (right-click), to help them figure out where more mines are and are not. (In our interface, the mine guess is denoted by a yellow square.)

##### Marking what may be a mine location. 
Usually a player would guess a mine location only when they could actually deduce that a mine goes there. However, there is a third state a covered mine location can have, and that's to just mark it with a question mark, to show that it's something they are thinking might be a mine, but aren't sure about. Marking a location this way does not affect the number of mine guesses.

If a mine is covered, one right click puts it as a mine guess (yellow), and another right click puts it as a question (shows ?, not yellow), and a third right click puts it back to the regular covered state.

##### Number of mines left display. 
When the game starts the number of mines still to be guessed is displayed at the upper left of the window, so the user knows how close they are to finishing. Guessing a mine (i.e., marking that location, as described above), will reduce that number by one whether the guess was correct or not. Although a user can guess more mines than there actually are, the display only goes down to zero (no negative number displayed). Note: some versions of the game out there let the displayed number go to negative, but our version will not.

The user can win without it reaching zero, because the win-condition is to open all the non-mine locations, not to guess any particular number of mines. The next diagram illustrates this situation.

##### Winning game display. 
When a player successfully opens all of the non-mine locations, the field display changes to show where the other mines are (it shows them as guesses, in yellow). I.e., these would be any unopened squares that weren't already yellow. The top middle of the window will show the happy face, and a message about winning will appear on the upper right of the window.

##### Losing game display. 
When a player opens a mine location, that mine explodes, and they lose the game. The exploded mine is shown by a red square. Any previously made incorrect guesses are shown with an X though them, the correctly guessed mine locations are still shown as guesses (yellow), and the other unopened mines are shown as "mines" (a black square, in our implementation). The top middle of the window will show the sad face, and a message about losing will appear on the upper right of the window.

##### Playing the game again. 
The user can play another game by clicking on the happy/sad face. It goes back to a happy face at the start of the new game, the game board shows all squares as unopened, and shows the original number of mines in the display of how many left to guess (top left).

##### Initial mine placement. 
On each game played, the mine locations are chosen at random, thus will be different for each game. The game works such that the first square opened is guaranteed not be a mine. To get that behavior the program can't choose the mine locations until the user opens the first square.

##### Clicking on an already-opened square. 
In our game clicking on a square that has already been opened will do nothing -- this is different than some other versions of the game you can play. (In other versions of the game clicking on an open square that has a number on it is a shortcut for opening all the neighboring non-guessed squares.)
