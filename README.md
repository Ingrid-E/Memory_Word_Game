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
- [ ] Add Player Object.

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
- [ ] Add Read and Write class.
- [ ] Fix comet speed.
- [ ] Make comet quantity.

### Created two new components

[Rotate Label](#)
------------

Creates a rotated JLabel, it works to put the titled word inside the comet.

[Comet Moving](#)
------------

Creates a JPanel that contains the Comet and the word, has a setText method to change the text shown in the comet. 
![Comet](ScreenShots/Day4.PNG)

------------------------

Made a new class [Game Controls](#) to control the comets and everything realted to gameplay, doesn't have much yet.

Thinking of making a font component to not load Nasalization in each class i need it.

![CometGif](ScreenShots/Comet.gif)

## Game Look 
![Game](ScreenShots/Game.gif)























