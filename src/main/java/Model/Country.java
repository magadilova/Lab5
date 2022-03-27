package Model;

public enum Country {
    FRANCE,
    INDIA,
    ITALY;

    public static void showCountryList(){
        for ( Country country : values()){
            System.out.println(country);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
