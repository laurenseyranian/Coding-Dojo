
public class HumanTest {

	public static void main(String[] args) {
		Ninja ninja1 = new Ninja();
		Ninja ninja2 = new Ninja();
		
		Wizard wizard1 = new Wizard();
		Wizard wizard2 = new Wizard();
		
		Samurai samurai1 = new Samurai();
		Samurai samurai2 = new Samurai();
		
		
		System.out.println(ninja1.getHealth());
		ninja1.steal(ninja2);
		System.out.println(ninja1.getHealth());
		System.out.println(ninja2.getHealth());
		
		
		System.out.println(wizard1.getHealth());
		wizard1.fireball(ninja2);
		System.out.println(wizard1.getHealth());
		System.out.println(ninja2.getHealth());
		
		
	}

}
