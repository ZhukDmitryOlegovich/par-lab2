public class Flight {
    private final int code;
    private final float delay;
    private static final int DEST_AIRPORT_ID_CSV_INDEX = 14;
    private static final int DELAY_CSV_INDEX = 18;

    public Flight(float delay, int code) {
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
        String[] list = csv.replaceAll("\"", "").split(",");
        return new Flight(
                list[DELAY_CSV_INDEX].length() > 0 ? Float.parseFloat(list[DELAY_CSV_INDEX]) : 0,
                Integer.parseInt(list[DEST_AIRPORT_ID_CSV_INDEX])
        );
    }
}
