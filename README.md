RingMaster
==========

Another game developed in under 24hours for the CSH Game Jam!

Overview
--------
A Player card is in the center Ring of 5 Action Card Slots.  Players may place
Action Cards into any Action Card Slot not currently in use by another Action
Card. At the end of each turn, the Ring rotates all Cards clockwise by the
number on the Rotation Number Card, which sits to the right of the Ring.
Passive Effect Cards may be placed in the singular Passive Effect Card slot
left of the Ring. Each player must strategically place Cards on the Ring and
control the Rotation Rate of their Ring and the Enemy's Ring. The goal is to
reduce the Enemy Player's Player Card to 0 health points; before they do!

Starting a Game
---------------
The Player hosting the Game must create a Hosted Game.  The Second Player must
then connect to the Hosting Player's Game by providing the IP Address of the
Host Player as an argument when starting the game.

Game Setup
--------
1. Place your Player Card in the center of the Ring
2. Place a 1 Rotation Card in the Rotation Card Slot
2. Draw five Cards from your Deck
3. The player hosting the game goes first

Turn Procedure
--------------
1. Play an Action Card on the Ring, or play a Rotation Control Card in the
	Rotation Card Slot
2. If present, activate the Action Card in the Action Card Slot
3. Rotate Ring by amount on the active Rotation Card
4. Draw a Card

Game Output
-----------
The below is an example of the board before the first move is made

RingMaster!
Connecting.......Connected!
    N     N

  N    @    N

       N      1
---------------------
1      N

  N    @    N

    N     N

1. MONSTER, ATTACK
2. MONSTER, ATTACK
3. BIG_MONSTER, ATTACK
4. POTION, SINGLE_USE
5. POTION, SINGLE_USE
>

Your board is on the bottom of the dashed separator.  Your Player Card (@) sits
undefended in the middle of all the Empty Cards (N). Your enemy has the same
setup above the dashed line, but mirrored.

The number in the top-left corner of you board is the current Rotation Card in
play. At the start, both players will have their Rings rotated by one. Keep in
mind the Rings will rotate Clockwise.

Your hand is the numbered list.  The name of the card is on the left, and the
type is on the right. To choose a card, its number is next to it.

The '>' indicates that the game is waiting for your input.

Game Commands
-------------
The below is an example of what running the available command set looks like.
> menu
play card pos - Place a card on the Ring
quit - Quit the game

> play 3 5
Placed card at 5.
Added MONSTER to hand.
Rotated CW by 1.

***

Dependencies
------------
* Java: 1.6
* Maven Library: apache-maven-3.0.4

Source Control
--------------
Github: https://github.com/grnt426/RingMaster

Building
--------
	mvn clean package

Executing
---------
As Server

	mvn exec:java
As Client

    mvn exec:java -Dexec.args=ip_address

or

As Server

	java -jar target/RingMaster-1.0-jar-with-dependencies.jar
As Client

    java -jar target/RingMaster-1.0-jar-with-dependencies.jar ip_address