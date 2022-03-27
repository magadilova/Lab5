package Model;

public enum EyeColor {
    GREEN,
    BLUE,
    WHITE,
    BROWN;

    static public void showEyeColorsList() {
        for (EyeColor color : values()) {
            System.out.println(color);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
