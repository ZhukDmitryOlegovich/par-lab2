import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Pattern;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final Pattern REGEXP_NOT_WORD = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = REGEXP_NOT_WORD.split(value.toString().toLowerCase());
        
        for (String word : words) {
            context.write(new Text(word), new IntWritable(1));
        }
    }
}