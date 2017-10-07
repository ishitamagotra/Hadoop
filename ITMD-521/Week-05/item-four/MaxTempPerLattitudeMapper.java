import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTempPerLattitudeMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {
  private static final int MISSING = 9999;
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    String line = value.toString();
    char la;
    String LYear = "";
    if (line.charAt(28) == '-') { 
        la = line.charAt(29); 
	
	{
  if(la=='0')
		LYear = "Latitude between  0 to -9";
	if(la=='1')
		LYear = "Latitude between -10 to -19";
	if(la=='2')
		LYear = "Latitude between -20 to -29";
	if(la=='3')
		LYear = "Latitude between -30 to -39";		
	if(la=='4')
		LYear = "Latitude between -40 to -49";
	if(la=='5')
		LYear = "Latitude between -50 to -59";
	if(la=='6')
		LYear = "Latitude between -60 to -69";
	if(la=='7')
		LYear = "Latitude between -70 to -79";
	if(la=='8')
		LYear = "Latitude between -80 to -89";
	else
		LYear = "Latitude between -90       ";
      }
    }
    int airTemperature;
    if (line.charAt(87) == '+') 
     { 
      airTemperature = Integer.parseInt(line.substring(88, 92));
    } 
    else {
      airTemperature = Integer.parseInt(line.substring(87, 92));
    }
    String quality = line.substring(92, 93);
    if (airTemperature != MISSING && quality.matches("[01459]")) 
    {
	if(LYear != "")
	{
      context.write(new Text(LYear), new IntWritable(airTemperature));
	}
    }
  }
}
