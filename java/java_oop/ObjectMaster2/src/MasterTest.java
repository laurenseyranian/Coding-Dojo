public class MasterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wizard nora = new Wizard();
		Ninja lindsey = new Ninja();
		Samurai lauren = new Samurai();
		Samurai adrian = new Samurai();
		nora.attack(lindsey);
		
		System.out.println("Nora the wizard");
		nora.heal(lauren);
		nora.fireball(lindsey);
		
		System.out.println("Lindsey the ninja");
		lindsey.steal(lauren);
		lindsey.runAway();
		
		System.out.println("Lauren the samurai");
		lauren.deathBlow(nora);
		Samurai.howMany();
	}

}
