import abstractfactory.MedievalWorldFactory;
import abstractfactory.SciFiWorldFactory;
import abstractfactory.WorldFactory;
import character.Character;
import weapon.Weapon;

public class GameClient {
    private Character character;
    private Weapon weapon;

    public void createWorld(WorldFactory f) {
        character = f.createCharacter();
        weapon = f.createWeapon();

        System.out.println(character.describe());
        System.out.println(weapon.use());
    }

    public static void main(String[] args) {
        GameClient g = new GameClient();

        System.out.println("Mittelalterliche Welt:");
        WorldFactory medievalFactory = new MedievalWorldFactory();
        g.createWorld(medievalFactory);

        System.out.println("\nScience-Fiction-Welt:");
        WorldFactory sciFiFactory = new SciFiWorldFactory();
        g.createWorld(sciFiFactory);

    }
}