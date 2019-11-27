
public class Samurai extends Human {
	static int count = 0;
	public Samurai() {
		this.health += 100;
		displayStats();
		count++;
	}
	public void deathBlow(Human enemy) {
		enemy.health = 0;
		health /= 2;
		enemy.displayStats();
		displayStats();
	}
	public void meditate() {
		health = 200;
		displayStats();
	}
	public static void howMany() {
		System.out.println("There are "+count+" Samurai's");
	}
	
}
