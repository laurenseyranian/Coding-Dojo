class Ninja extends Human {
	public Ninja() {
		this.stealth += 7;
	}
	public void steal(Human stealHuman) {
		System.out.println("Ninja stole stealth");
		stealHuman.health -= this.stealth;
		health += this.stealth;
	}
	public void runAway() {
		System.out.println("Ninja ran away");
		this.health -= 10;
	}
}
