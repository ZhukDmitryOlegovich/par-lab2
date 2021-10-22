public class Airport {
    private int code;
    private String name;

    Airport(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Airport parseCSV(String csv) {
        String[] list = csv.split(",");
        String name = list[1].substring(1, list[1].length() - 1);
        String code = list[1].substring(1, list[1].length() - 1);
    }
}
