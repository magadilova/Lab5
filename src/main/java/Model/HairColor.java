package Model;


public enum HairColor {
    BLACK,
    BLUE,
    YELLOW,
    BROWN;

    static public void showHairColorList() {
        for (HairColor color : values()){
            System.out.println(color);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
