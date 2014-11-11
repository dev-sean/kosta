package ex1;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayApps {
	private Date date;
	private SimpleDateFormat format;



	public void setDate(Date date) {
		this.date = date;
	}



	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}



	public String printDate(){
		
		return format.format(date);
	}
}
