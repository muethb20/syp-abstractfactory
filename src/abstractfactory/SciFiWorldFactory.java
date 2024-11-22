package abstractfactory;

import character.Character;
import character.Spaceman;
import weapon.LaserGun;
import weapon.Weapon;

public class SciFiWorldFactory implements WorldFactory {

    @Override
    public Character createCharacter() {
        return new Spaceman();
    }

    @Override
    public Weapon createWeapon() {
        return new LaserGun();
    }
}
