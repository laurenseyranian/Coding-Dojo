public class Human {
	protected int strength = 3;
	protected int stealth = 3;
	protected int intelligence = 3;
	protected int health = 100;
	
	public void attack(Human attackedHuman) {
		attackedHuman.health -= this.strength;
	}
	public int getHealth() {
		return health;
	}
	public int getStealth() {
		return stealth;
	}
	public int getStrength() {
		return strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
}
