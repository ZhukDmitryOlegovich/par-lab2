import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    public AirportComparator() {
        super(AirportJoinKey.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return ((AirportJoinKey) a).getAirportId() - ((AirportJoinKey) b).getAirportId();
    }
}
