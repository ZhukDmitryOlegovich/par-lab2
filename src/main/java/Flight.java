public class Flight {
    private final int code;
    private final float delay;
    private static final int DEST_AIRPORT_ID_CSV_INDEX = 14;
    private static final int DELAY_CSV_INDEX = 18;

    public Flight(int code, float delay) {
        this.code = code;
        this.delay = delay;
    }

    public float getDelay() {
        return delay;
    }

    public int getCode() {
        return code;
    }

    public static Flight parseCSV(String csv) {
        String[] list = csv.split(",", 1);
        return new Flight(
                Integer.parseInt(list[DEST_AIRPORT_ID_CSV_INDEX]),
                list[DELAY_CSV_INDEX].length() > 0 ? Float.parseFloat(list[DELAY_CSV_INDEX]) : 0
        );
    }
}
