public class Flight {
    private final float delay;
    private final int code;
    private static final int DEST_AIRPORT_ID_CSV_INDEX = 14;
    private static final int DELAY_CSV_INDEX = 18;

    public Flight(float delay, int code) {
        this.delay = delay;
        this.code = code;
    }

    public static Flight parseCSV(String csv) {
        String[] list = csv.replaceAll("\"", "").split(",");
        return new Airport(Integer.parseInt(list[CODE_CSV_INDEX]), list[NAME_CSV_INDEX]);
    }
}
