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
then connect to the Hosting Player's Game by entering the Host's IP address.

Game Setup
--------
1. Place your Player Card in the center of the Ring
2. Place a 1 Rotation Card in the Rotation Card Slot
2. Draw five Cards from your Deck
3. Flip a coin to determine starting Player

Turn Procedure
--------------
1. Play an Action Card on the Ring, or place an Effect Card in the Effect Slot,
or play a Rotation Control Card in the Rotation Card Slot
2. If present, activate the Action Card in the Action Card Slot
3. Rotate Ring by amount on the active Rotation Card
4. Draw a Card

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
	mvn exec:java
or

	java -jar target/RingMaster-1.0-jar-with-dependencies.jar