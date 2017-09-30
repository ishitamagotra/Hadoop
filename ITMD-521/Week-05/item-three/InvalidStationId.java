// cc MaxTemperature Application to find the maximum temperature in the weather dataset
// vv MaxTemperature
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class InvalidStationId {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: InvalidStationId <input path> <output path>");
      System.exit(-1);
    }

    Job job = new Job(new Configuration(), "InvalidStationId");
    job.setJarByClass(InvalidStationId.class);
    job.setJobName("Invalid StationID");

    job.setMapperClass(InvalidStationIdMapper.class);
    job.setCombinerClass(InvalidStationIdReducer.class);
    job.setReducerClass(InvalidStationIdReducer.class);

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    job.waitForCompletion(true);
  }
}
// ^^ MaxTemperature
