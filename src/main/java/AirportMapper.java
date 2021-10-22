import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Pattern;

public class AirportMapper extends Mapper<LongWritable, Text, AirportJoinKey, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) {
            return;
        }

        Airport airport = Airport.parseCSV(value.toString());
        context.write(
                new AirportJoinKey(airport.getCode(), true),
                new Text(airport.getName())
        );
    }
}