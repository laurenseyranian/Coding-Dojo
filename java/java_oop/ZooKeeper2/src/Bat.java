
	class Bat extends Mammal {
		
		public Bat () {
			this.energyLevel += 200;
		}
		
		public void fly() {
	        System.out.println("The Bat flew.");
	        energyLevel -= 50;
		}
		public void eatHumans() {
	        System.out.println("The Bat ate humans.");
	        energyLevel += 25;
		}
		public void attackTown() {
	        System.out.println("The town is on fire.");
	        energyLevel -= 100;
		}
	}

