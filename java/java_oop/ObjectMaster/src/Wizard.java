class Wizard extends Human {
	public Wizard() {
		this.health -= 50;
		this.intelligence += 5;
	}
	public void heal(Human healHuman) {
		System.out.println("Wizard healed human");
		healHuman.health += this.intelligence;
	}
	public void fireball(Human fireballHuman) {
		System.out.println("Wizard fireballed human");
		fireballHuman.health -= this.intelligence*3;
	}
}
