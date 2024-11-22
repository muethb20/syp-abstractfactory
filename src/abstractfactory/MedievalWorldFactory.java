package abstractfactory;

import character.Character;
import character.Knight;
import weapon.Sword;
import weapon.Weapon;

public class MedievalWorldFactory implements WorldFactory{
    @Override
    public Character createCharacter() {
        return new Knight();
    }

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }
}
