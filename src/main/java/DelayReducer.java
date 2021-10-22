import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class DelayReducer extends Reducer<AirportJoinKey, Text, Text, Text> {
    @Override
    protected void reduce(
            AirportJoinKey key,
            Iterable<Text> values,
            Reducer<AirportJoinKey, Text, Text, Text>.Context context
    ) throws IOException, InterruptedException {
        Iterator<Text> it = values.iterator();
        String name = it.next().toString();

        if (!it.hasNext()) {
            return;
        }

        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        float sum = 0;
        int count = 0;
        for (; it.hasNext(); count++) {
            String s = it.next().toString();
            System.err.println(s);
            float delay = Float.parseFloat(s);
            max = Math.max(max, delay);
            min = Math.min(min, delay);
            sum += delay;
        }

        context.write(
                new Text(name),
                new Text(String.format("avg: %f, \tmin: %f, \tmax: %f", sum / count, min, max))
        );
    }
}
