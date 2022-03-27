package Model;

public enum UnitOfMeasure {
    CENTIMETERS,
    MILLILITERS,
    MILLIGRAMS;

    public static void showUnitOfMeasureList(){
        for ( UnitOfMeasure unitOfMeasure : values()){
            System.out.println(unitOfMeasure);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
