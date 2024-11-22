package character;

public class Spaceman implements Character {
    @Override
    public String describe() {
        return "Ein futuristischer Raumfahrer mit Power-Rüstung";
    }

    @Override
    public String getImagePath() {
        return "spaceman.jpg";
    }
}
