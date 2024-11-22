package character;

public class Knight implements Character{
    @Override
    public String describe() {
        return "Ein Ritter in glänzender Rüstung";
    }

    @Override
    public String getImagePath() {
        return "knight.jpg";
    }
}
