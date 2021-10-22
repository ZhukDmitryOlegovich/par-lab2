public class Airport {
    private final int code;
    private final String name;
    private static final int CODE_CSV_INDEX = 0;
    private static final int NAME_CSV_INDEX = 0;

    Airport(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Airport parseCSV(String csv) {
        String[] list = csv.replaceAll("\"", "").split(",");
        return new Airport(Integer.parseInt(list[CODE_CSV_INDEX]), list[NAME_CSV_INDEX]);
    }
}
