import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: <CSV airports> <CSV flights> <output>");
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJarByClass(App.class);
        job.setJobName("Airport-flight join");

        {
            MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportMapper.class);
            MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightMapper.class);

            job.setGroupingComparatorClass(AirportComparator.class);
            job.setReducerClass(DelayReducer.class);
            job.setPartitionerClass(PartitionerAirportJoinKey.class);
        }

        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setMapOutputKeyClass(AirportJoinKey.class);
        job.setMapOutputValueClass(Text.class);

//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);
//        job.setNumReduceTasks(2);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}