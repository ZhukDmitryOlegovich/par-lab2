import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, AirportJoinKey, Text> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, AirportJoinKey, Text>.Context context)
            throws IOException, InterruptedException {
        if (key.get() == 0) {
            return;
        }

        Flight flight = Flight.parseCSV(value.toString());
        if (flight.getCode() > 0) {
            context.write(
                    new AirportJoinKey(flight.getCode(), false),
                    new Text(String.valueOf(flight.getDelay()))
            );
        }
    }
}