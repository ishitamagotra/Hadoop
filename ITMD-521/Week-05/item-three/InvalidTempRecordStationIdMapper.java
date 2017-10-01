import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class InvalidTempRecordStationIdMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {
  
    private static final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
    String year = line.substring(15, 19);
    String inv = line.substring(5, 11);
	if (inv.startsWith("999999")) {
		
	StringTokenizer tokenizer = new StringTokenizer(inv);
	
	while (tokenizer.hasMoreTokens()) {
		word.set(tokenizer.nextToken());
		context.write(word, one);
	}
	
  }
  
}
  }


// ^^ InvalidStationMapper

