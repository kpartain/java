import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>() {{
            put("H.","Recalling all of the times I have died, and will die, it's all right, I don't mind.");
            put("Born In Winter","Before all things reborn again, you learn the painful breath of time.");
            put("Blood and Thunder","I think that someone is trying to kill me - infecting my blood and destroying my mind.");
            put("Omerta","For a wounded man shall say to his assailant: if I live, I will kill you. If I die, you are forgiven. Such is the rule of honor.");
        }};
        System.out.println(trackList.get("Omerta"));
        trackList.forEach( (k,v) -> System.out.println(k + ": " + v + "\n"));
    }
}
