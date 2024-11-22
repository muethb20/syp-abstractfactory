package abstractfactory;

import character.Character;
import weapon.Weapon;

public interface WorldFactory {
    Character createCharacter();
    Weapon createWeapon();
}
