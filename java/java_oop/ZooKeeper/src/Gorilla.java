
class Gorilla extends Mammal {
	public void throwSomething() {
        System.out.println("The Gorilla threw something.");
        energyLevel -= 5;
	}
	public void eatBananas() {
        System.out.println("The Gorilla ate bananas.");
        energyLevel += 10;
	}
	public void climb() {
        System.out.println("The Gorilla has climbed a tree.");
        energyLevel -= 10;
	}
}
