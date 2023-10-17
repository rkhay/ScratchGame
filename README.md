# ScratchGame
# Input:
--config  <"path to config.json">

--betting-amount 500 // betting ammount

# Expected Output
{ "matrix":[<br>
[A, B, F, D]<br>
[D, B, C, MISS]<br>
[F, F, D, F]<br>
[E, B, E, C]
],<br>
"reward": 990,<br>
appliedWinningCombinations={B=[SameSymbol3Times], D=[SameSymbol3Times], F=[SameSymbol4Times]} appliedBonusSymbol='MISS'}

# How to launch
java -jar scratchGame-1.0-SNAPSHOT.jar --config config.json --betting-amount 100
Predefined json configuration file can be found in the resources folder


# How it works
The game parses json configuration file and builds a matrix based on that data. Then the reward is calculated.
Here are rewarding cases: matching symbols, matching diagonal symbols and bonus symbols.








