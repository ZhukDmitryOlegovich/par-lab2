import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportJoinKey, Text> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, AirportJoinKey, Text>.Context context)
            throws IOException, InterruptedException {
        if (key.get() == 0) {
            return;
        }

        Airport airport = Airport.parseCSV(value.toString());
        context.write(
                new AirportJoinKey(airport.getCode(), false),
                new Text(airport.getName())
        );
    }
}