public class ProjectTest {
    public static void main(String[] args) {
        Project first = new Project();
        first.setName("First Project");
        first.setDescription("Practice overloading methods such as constructors and implement getters and setters.");
        System.out.println(first.getName());
        System.out.println(first.getDescription());

        Project second = new Project ("Favorite Java Project", "My favorite java project");

        Project third = new Project ("Third Project", "Still learning Java Fundamentals!");

        Project fourth = new Project ("Another Project", "Java is cool.");

    }
}