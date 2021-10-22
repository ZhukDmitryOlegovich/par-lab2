import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return 1;
//        return ((AirportJoinKey) a).getAirportId() - ((AirportJoinKey) b).getAirportId();
    }
}
