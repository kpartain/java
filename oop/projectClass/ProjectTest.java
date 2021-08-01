public class ProjectTest {
    private static void main(String[] args) {
        Project overloadOne = new Project();
        Project overloadTwo = new Project("overloadTwo");
        Project overloadThree = new Project("overloadThree", "The third method");
        overloadOne.setName("overloadOne");
        overloadOne.setDescription("The first method");
        overloadTwo.setDescriotion("The second method");
        ArrayList<Project> lessTyping = new ArrayList<Project>();
        lessTyping.add(overloadOne);
        lessTyping.add(overloadTwo);
        lessTyping.add(overloadThree);
        for(Project eachProject : lessTyping) {
            System.out.println("GETTER NAME: " + eachProject.getName());
            System.out.println("GETTER DESC: " + eachProject.getDescription());
        }
    }
}
