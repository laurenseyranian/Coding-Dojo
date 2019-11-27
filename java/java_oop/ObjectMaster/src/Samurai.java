class Samurai extends Human {
	public Samurai() {
		this.health += 100;
		count ++;
	}
	private static int count = 0;
	
	public void deathBlow(Human deathBlowHuman) {
		System.out.println("Samurai death blew");
		this.health = this.health/2;
		deathBlowHuman.health = 0;
	}
	public void meditate() {
		System.out.println("Samurai meditated");
		this.health += this.health/2;
	}
	public static int howMany() {
		System.out.println("Total number of Samurai");
		return count;
	}
}
