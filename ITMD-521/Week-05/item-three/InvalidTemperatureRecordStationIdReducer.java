// cc InvalidTemperatureReducer Reducer for minimum temperature example
// vv InvalidTemperatureReducer
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class InvalidTemperatureRecordStationIdReducer
  extends Reducer<Text, IntWritable, Text, FloatWritable> {
    Text stationid = new Text();
  Float count = 0f;
  Float total = 0f;  
  Float percentage = 0f;
      public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException 
	  {
          Float sum = 0f;
		  Float icount = 0f;
		  
          for (IntWritable value : values) 
		    {
				icount++;
				            }
	total = total+icount;
        System.out.println("Total"+total);		
            if(icount > count)
            {
                count = icount;
                stationid.set(key);
            }
	  }
	  
	  @Override
	  protected void cleanup(Context context) throws IOException, InterruptedException {
          percentage = (count/total)*100;	   
        context.write(stationid,new FloatWritable(percentage));
  }
  }
// ^^ InvalidTemperatureReducer

