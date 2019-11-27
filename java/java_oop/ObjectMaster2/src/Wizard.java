public class Wizard extends Human {
	
	public Wizard() {
		this.health -= 50;
		this.intelligence += 5;
		displayStats();
	}
	public void heal(Human teammate) {
		teammate.health += this.intelligence;
		teammate.displayStats();
	}
	public void fireball(Human enemy) {
		enemy.health -= (this.intelligence * 3);
		enemy.displayStats();
	}
}