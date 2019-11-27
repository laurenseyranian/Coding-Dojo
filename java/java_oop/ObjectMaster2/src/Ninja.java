
public class Ninja extends Human {
	public Ninja() {
		this.stealth += 7;
		displayStats();
	}
	public void steal(Human enemy) {
		enemy.health -= this.stealth;
		health += this.stealth;
		enemy.displayStats();
		displayStats();
	}
	public void runAway() {
		health -= 10;
	}
}
