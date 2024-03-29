import java.util.*;

public class Configuration {
	public int interval;

	public int duration;

	public int departure;
	
	//I made code shorter and readable than before

	public void load(Properties props) throws ConfigurationException {
		    interval = checkInterval(props);
	        duration = checkDuration(props);
	        departure = checkDeparture(props);
		
	}
		
	    public int checkInterval(Properties props) throws ConfigurationException {
			String valueString;
			int value;
	     
			valueString = props.getProperty("interval");
	        if (valueOfString == null) {
	            //removed "monitor" from exception string
	            throw new ConfigurationException("monitor interval");
	        }
	        value = Integer.parseInt(valueString);
	        if (value <= 0) {
	            throw new ConfigurationException("monitor interval > 0");
	        }

	        return value;
	    }

	    
	   
	    public int checkDuration(Properties props) throws ConfigurationException {
	    	String valueString;
			int value;
			
			valueString = props.getProperty("duration");
	        if (valueString == null) {
	            throw new ConfigurationException("duration");
	        }
	        value = Integer.parseInt(valueString);
	        if (value <= 0) {         
	            throw new ConfigurationException("duration > 0");
	        }if ((value % interval) != 0) {
	            throw new ConfigurationException("duration % interval");
	        }

	        return value;
	    }
	    
	     
	    
	    public int checkDeparture(Properties props) throws ConfigurationException {
	    	String valueString;
			int value;
	        
	        valueString = props.getProperty("departure");
	        if (valueString == null) {
	            
	            throw new ConfigurationException("departure offset");
	        }
	        value = Integer.parseInt(valueString);
	        if (value <= 0) {
	            throw new ConfigurationException("departure > 0");
	        }if ((value % interval) != 0) {
	            throw new ConfigurationException("departure % interval");
	        }

	        return value;
	    }
	    
}
