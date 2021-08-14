# Memordy

**Memory Word Game**
-Mini Proyect 3 for my interactive programming class in U.

## Day 1 🤗
Creating the Main Menu GUI. Added a component that changes images sizes, even gifs keeping their animation. 

[Image Resize Component](https://github.com/Ingrid-E/Memory_Word_Game/blob/main/MemordyComponents/src/components/ImageResize.java) 😄

------------


Added Font [Nazalization](http://typodermicfonts.com/)

Added Title and Buttons. 

![Main Menu Look](ScreenShots/Day1.PNG)

**Trying to add only one mouse, text, listener class.**

------------
- [x] Finish New Game GUI.

## Day 2 

Almost Finished with NewGameGui.
- [x] Add back to main menu button.
- [x] Add next button

Still haven't added file reading, leaving that for the end.

Added Characters to the game.

![Men](Memordy/src/images/Men.png)
![Woman](Memordy/src/images/Woman.png)
![Cat](Memordy/src/images/Cat.png)

------------

Put exit and background elements in constructor so it can be reused just by calling it.
**Removed JFrame decoration, and added MouseMotion to move the window with mouse clicking anywhere.**

Finished look for today:

![New Game Look](ScreenShots/Day2.PNG)

## Day 3 

Added Next and Back button to allow player navigate around the game.

Fixed and error that made listener not work.

Finished load game GUI.
- [x] Add Player Object.

### Created a new component

[Choose Saved Game](https://github.com/Ingrid-E/Memory_Word_Game/blob/33b7916dfcc30fe499d3b65c256a516e60bebd71/MemordyComponents/src/components/ChooseSavedGame.java)

Shows player icon (Without save it's a grey icon), name and level. 
Needs a player object to get name, and current level, will create another 
constructor when i have created this object.

![NewComponent](ScreenShots/ChooseSavedGameComponent.PNG)

------------

### Load Game GUI Look

![LoadGame](ScreenShots/Day3.PNG)

## Day 4

Working in the words showing, still need to create the class that reads and writes files.
- [x] Add Read and Write class.
- [ ] Fix comet speed.
- [ ] Make comet quantity.

### Created two new components

[Rotate Label](https://github.com/Ingrid-E/Memory_Word_Game/blob/main/MemordyComponents/src/components/RotateLabel.java)
------------

Creates a rotated JLabel, it works to put the titled word inside the comet.

[Comet Moving](https://github.com/Ingrid-E/Memory_Word_Game/blob/main/MemordyComponents/src/components/CometMoving.java)
------------

Creates a JPanel that contains the Comet and the word, has a setText method to change the text shown in the comet. 
![Comet](ScreenShots/Day4.PNG)

------------------------

Made a new class [Game Controls](https://github.com/Ingrid-E/Memory_Word_Game/blob/main/Memordy/src/memordy/GameControls.java) to control the comets and everything realted to gameplay, doesn't have much yet.

Thinking of making a font component to not load Nasalization in each class i need it.

![CometGif](ScreenShots/Comet.gif)

## Game Look 
![Game](ScreenShots/Game.gif)

## Day 5

Added Player Class which contains basic player info.

Added GameData Class which reads and writes game data in a .txt file. Using ObjectOutputStream, the data class contains the players in an ArrayList.

Added another constructor to ChooseSavedGame that makes the component with player icon and data.

Added another constructor to ImageResize that adds Icon compability, it first turns the Icon to Image than load to ImageFile.

- [ ] Add scroll when there are more than 3 players.
- [ ] Add choose player in load game.
- [ ] Finish game concept

## Day 6

Organized gaming components in GameControls and left all releated to interface in MainMenu.java.

Added words to game, and randomized words for each player, so they will have a random order of words but they wont repeat.

Saved the information in a HashMap for player and player words.

Example:

```json
{"Ingrid": ["word1", "word2", "word3", "word4", "word5",...],
 "Jhonatan": ["word3", "word1", "word2", "word7", "word4",...]
}
```

That way words do not repeat for every player in the same order.

- [x] Add Write words GUI
- [ ] Add Next Level functions
- [ ] Add go back to menu function
- [ ] Add Load existing game

Added ArrayList to GameData so the comets show the order of the words.

## Day 7

- [x] ** When creating new player, add restrintions to same name and obligatry to choose icon or else it will generate errors **

Fix Adding enter and adding the words in a gridLayout mode

## Day 8
got stuck all day trying to do something that is not posible. F

## Day 9

Made JTable that shows words with invisible background and added a font size that works for all words that are it's len is 13 or lower.

What if the user inputs a word longer? Will it break the code?
Yes... need to **fix that**

## Day 10

No! Dont need to fix that because the only words that will get added to the word table are that ones that are correct!

Added enconding to file reader so that it comes out with "tildes" and i can do a spanish version. 

Creating word level game array containenr so that it contains the words of the two sets for the player.

- [x] Add to only show words that work in tableWords
- [x] Add wrong word look to TextField

## Day 11

Added red outline when incorrect word is inputted
Added green color when all words are inputted

## Day 12

Added Next Levels!

- [ ] Add to show how many correct words the user inputted in that level
















