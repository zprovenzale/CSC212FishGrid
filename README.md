# P2: Finding Fish (Lists)

[Online Javadoc](https://jitpack.io/com/github/jjfiv/CSC212P2/1.2/javadoc/)

This assignment will be easier to debug (because it moves slower), less graphical, and more about ``List``s! The fish lives in a grid (2d space) but we mostly only use a ``List`` of objects to represent that.

![Image of Finding Fish Game](P2.png)

The learning objectives of this assignment are twofold:

1. Learn more Java! Read some bigger starter-code and ask questions!
2. Practice using ``List``s! Almost every TODO I left is about a ``List``, although there are some about adding fields to classes.

***Due Date***: February 14, 2019.

Remember that we will have P3 opening on that day, so don't save it until the last minute!

## TODO(lab) and TODO(P2) Fixing!

Eclipse highlights all the TODO comments that I left throughout the starter code as blue in the scroll-bar.
We're going to work through a bunch of them in Lab! And some of them are left for later, when working on P2 directly.

- When you finish a TODO, delete it!
- TODO(P2) are meant for after lab (once you have a better idea of how the game works).
- In Eclipse, you can see all remaining TODOs by going to "Window > Show View > Tasks"!
- Every solution is just a few lines of code (sometimes even one!) So don't stress out if you spend a lot of time thinking before writing anything (that's intentional).

# Rubric

### Rubric and Reflection (=15)

You must include a PDF file in your submission that identifies the grade you expect on this assignment based on what you completed. 

In addition, you will write 10 statements of either:
 - Accomplishments: things that you understand much better now.
 - Challenges: things that you are still working on understanding.

I will provide direct feedback to your writing.

## Program Compiles (=15)
This includes that your code should be professional. 
- Try to proofread your work like an essay! 
- Find all your ``println("stuff")`` statements and remove them, etc.
- Your code looks intentional: don't just fiddle with it until it works. Reason about it! Sketch out the python by hand and then try translating to Java.
- Delete commented out code or experiments that don't work out. Make your submission as small as it needs to be.
- Your code is your own. Respect the honor code.
- Working with others or helping them debug is acceptable - use your best judgment! Make sure that you know what you're working on.
- Have comments explaining tricky code!

## Lab warm-up & code tour (=30).

### PlayFish class (=5)
 - You don't need to edit anything but the CONSTANTS in this class for this assignment at all. It's pretty smart already!
 - Play the game (WASD or arrow keys). The goal is to collect all the fish. (They just disappear when you get them now).
 - Change VISUAL_GRID_SIZE to be bigger so you can see details (but not so big it doesn't fit on your screen!).
 - Don't change LOGICAL_GRID_SIZE to be too small! You won't be able to play.

### Fish class (=5)
The ``Fish`` class for P2 is familiar, but much simpler! It lives on a grid called the ``World`` and doesn't move itself.
- Add fish-colors. The ``COLORS`` static array has a list of a few colors. Create more.
- Skip the TODO(P2) for now. We don't know where scoring happens, yet!
- Understand how the color is selected by the drawing code into this array.
- Play the game and see how many more fish appear. (Revisit ``LOGICAL_GRID_SIZE`` if too small).

### Rock class (=5)
Right now there are only a few rocks, but they're all the same color and are boring. I created an array of colors in the ``Rock`` class, but I forgot to hook it up. Let's assign rock colors randomly!

### WorldObject class Tour
A ``Fish`` is-a ``WorldObject``. A lot more functionality is on this class. Every ``WorldObject`` knows how to ``moveUp``, ``moveDown``, ``moveLeft``, ``moveRight``, and ``moveRandomly``. They keep track of their recent positions in a special list called a ``Deque`` -- or double-ended queue ... there's not a whole lot to it except that it's easy to add and remove from both sides.

There is a lot in the ``WorldObject`` class, we will be users of it, rather than editors of it.

### FishGame class Tour (=12)

``FishGame`` tracks behavior of fish by which list they belong in. We could have had fish swim themselves, kind of like P0 (and have flags for lost, found, and eventually home) but we want to practice using ``List<Fish>`` and ``List<WorldObject>`` inside of ``FishGame``.

- ***Wander Missing Fish*** - The ``FishGame`` class has a method called ``wanderMissingFish``. The for loop is almost done, but we want to call one fo the ``Fish`` movement methods on the fish in the loop. Fix my TODO and play the game again to make sure it works.
- ***Right now we only generate 5 rocks!*** - also, ``public static final int NUM_ROCKS``?
- ***We want a ``Snail`` or two*** - there's a world method to insert a snail randomly; let'ls use it.
- ***world.remove(wo)*** - Right now when we find fish we remove them from the world; this doesn't make sense. We want to delete that line and add a line that adds the fish to the list of "found" ``Fish``. We will have to cast our ``WorldObject`` to a ``Fish`` to do it. We are telling Java we know that it is a ``Fish``, so it is okay to use ``Fish`` methods. It will crash later if it was really a ``Rock`` and not a ``Fish``.

### Lab Challenge: Fish.fastScared (=4)
No TODO for this (the challenge is to know where the edits belong).

Right now, lost fish move 3 out of every 10 turns (because ``rand.nextDouble`` chooses a number from 0 to 1). This section proposes making two types of fish that have two different probabilities.

- Lost fish may be ``fastScared`` (with some random probability). 
- They will move more often randomly if ``fastScared`` (p=0.8)? 
- Some percentage of Fish just hang out without moving as much (p=0.3).

### Lab Challenge: FallingRock (=4)
No TODO for this either (the challenge is to know where the edits belong).

Create a class ``FallingRock`` that extends ``Rock`` and overrides ``public void step() { }`` to move the rock down on every step it can (you can call the ``WorldObject`` method ``moveDown`` as ``this.moveDown()`` because a ``FallingRock`` is a ``Rock`` and all ``Rock``s are ``WorldObject``s, too!

# Assignment Core (25)

## Explain the Fish Follow Logic (=10)
- (World.java) Answer the questions in ``World.objectsFollow``.
- ``System.out.println`` statements can help you debug this.

## Finishing the Game (=15)
These are the rest of the TODO(P2); they are a bit harder than the TODO(lab) but you should have a better idea what code does what now.

- (Fish.java, FishGame.java) Have each fish worth some individual number of points (maybe based on color!).
- (FishGame.java) Finish ``click(x,y)`` so that a user can click and remove rocks in case we generate a fish trapped in a cave!
- (World.java) Right now, we only respect ``Snail`` space. ``Fish`` shouldn't step on each other (unless you're the player, collecting lost Fish) and Fish can't actually swim through rocks! (And vice-versa. Your falling-rocks shouldn't go through your fish.)

# Optional Challenges

There are no TODO comments in the code for challenges. Now you will have to use what you've figured out about how the code works to find edits. Challenge 1 has files that are a hint, the other two challenges involve making new classes.

## Challenge 1: Making FishHome work (=20)
- (FishGame.java) Right now, we win as soon as we find all the Fish. We want to bring them home, too. Whenever your player returns to the home, the fish that are in the found list should move to a new "home" list. Only when that list is full have we "won". You can ``world.remove(fish)`` that get home, so they're not all stacked on top of the house.
- (FishGame.java) After 20 or so steps (you can change this) a fish that is too far back in the player's found team (more than 1 fish) has a chance of getting lost again every step (since they can't see you). This will encourage the player to visit the "home" more frequently.
- (FishGame.java) Fish that wander home by accident should be marked accordingly as home!

## Challenge 2: FishFood (=15)
- At random intervals, food will appear somewhere on the board (if it doesn't exist).
- The player will receive points for collecting the food.
- The lost fish will eat the food if they bump into it (and the player gets no points).

## Challenge 3: Bubble Traps (=25)
- Create a ``Bubble`` class that extends ``WorldObject``.
- Create a bubble state for ``Fish``. Right now the player sort of has a bubble drawn around them (you can use this drawing code).
- When a ``Fish`` bumps into a ``Bubble``, the bubble is removed and the fish enters a "bubble" state.
- A ``Fish`` caught in a bubble will be stuck within the bubble.
- A player can click to "pop" the bubble and free the fish.
- A player that bumps into a fish in a bubble will also free them.
- More Difficult (not included): Make bubbles merge with each other & pop when they hit rocks.
