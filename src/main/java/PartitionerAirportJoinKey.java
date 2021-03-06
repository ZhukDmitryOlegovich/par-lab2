import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.Text;

public class PartitionerAirportJoinKey extends Partitioner<AirportJoinKey, Text> {
    @Override
    public int getPartition(AirportJoinKey airportJoinKey, Text text, int i) {
        return airportJoinKey.getAirportId() % i;
    }
}
