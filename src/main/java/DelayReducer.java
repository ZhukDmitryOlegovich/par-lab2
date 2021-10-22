import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class DelayReducer extends Reducer<AirportJoinKey, Text, Text, Text> {
    @Override
    protected void reduce(AirportJoinKey key, Iterable<Text> values, Reducer<AirportJoinKey, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        Iterator<Text> it = values.iterator();

        it.forEachRemaining();
    }
}
