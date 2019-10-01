#1 If no arguments are provided, the function should return a random integer between 0 and 100.
import random, math
def randInt(min="", max=""):
    num = int(random.random() * 100)
    return num
print(randInt())
#2 If only a max number is provided, the function should return a random integer between 0 and the max number.
import random, math
def randInt(min="", max=""):
    num = int(random.random() * max)
    return num
print(randInt(max=50))
#3 If only a min number is provided, the function should return a random integer between the min number and 100
import random, math
def randInt(min="", max=""):
    num = int(random.randint(min, 100))
    return num
print(randInt(min=50))
#4 If both a min and max number are provided, the function should return a random integer between those 2 values.
import random, math
def randInt(min="", max=""):
    num = int(random.randint(min, max))
    return num
print(randInt(min=50, max=500))