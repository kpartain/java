public class Project {
    private String name;
    private String description;
    
    public Project() {

    }
    
    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }

    public void setName(String nameToSet){
        this.name = nameToSet;
    }
    public void setDescription(String descriptionToSet) {
        this.description = descriptionToSet;
    }
}
