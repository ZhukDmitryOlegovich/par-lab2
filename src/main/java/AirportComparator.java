import edu.umd.cs.findbugs.annotations.NonNull;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    @Override
    public int compare(@NonNull WritableComparable a, @NonNull WritableComparable b) {
        return 0;
//        return ((AirportJoinKey) a).getAirportId() - ((AirportJoinKey) b).getAirportId();
    }
}
