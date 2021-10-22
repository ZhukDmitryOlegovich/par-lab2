import org.apache.hadoop.io.WritableComparable;

public class AirportJoinKey implements WritableComparable<AirportJoinKey> {
    private int airportId;
    private byte isAirport;

    AirportJoinKey(int airportId, byte isAirport) {
        this.airportId = airportId;
        this.isAirport = isAirport;
    }

    public int getAirportId() {
        return airportId;
    }

    @Override
    public int compareTo(AirportJoinKey o) {
        return airportId - o.airportId || isAirport - o.isAirport;
    }
}
