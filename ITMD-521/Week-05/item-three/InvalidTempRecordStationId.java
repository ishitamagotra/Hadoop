import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class InvalidTempRecordStationId {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: InvalidTempRecordStationId <input path> <output path>");
      System.exit(-1);
    }
    
    Job job = new Job(new Configuration(), "InvalidTempRecordStationId");
    
	job.setJarByClass(InvalidTempRecordStationId.class);
    job.setJobName("Invalid Temp Record Station Id");

    job.setMapperClass(InvalidTempRecordStationIdMapper.class);
	job.setCombinerClass(InvalidTempRecordStationIdReducer.class);
    job.setReducerClass(InvalidTempRecordStationIdReducer.class);

	FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
	job.waitForCompletion(true);
  }
}
// ^^ InvalidStation

