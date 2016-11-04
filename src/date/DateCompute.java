package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompute {

	public static void main(String[] args) throws ParseException {
		Date begin = new Date();
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date end=dfs.parse("2017-01-31 05:15:00");
		String result1 = getTimeDifference1(begin,end);
		System.out.println(result1);
		String result2 = getTimeDifference2(begin,end);
		System.out.println(result2);
		String result3 = getTimeDifference3(begin,end);
		System.out.println(result3);
	}
	
	private static String getTimeDifference1(Date begin,Date end){
		long days = 0;
		try
		{
		    long diff = end.getTime() - begin.getTime();
		    days = diff / (1000 * 60 * 60 * 24);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		String result = ""+days+"天";
		return result;
	}
	
	private static String getTimeDifference2(Date begin,Date end){
		long l = end.getTime() - begin.getTime();
		long day=l/(24*60*60*1000);
		long hour=(l/(60*60*1000)-day*24);
		long min=((l/(60*1000))-day*24*60-hour*60);
		long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		String result = ""+day+"天"+hour+"小时"+min+"分"+s+"秒";
		return result;
	}
	
	private static String getTimeDifference3(Date begin,Date end){
		long between=(end.getTime()-begin.getTime())/1000;   //除以1000是为了转换成秒
		long day1=between/(24*3600);
		long hour1=between%(24*3600)/3600;
		long minute1=between%3600/60;
		long second1=between%60/60;
		String result = ""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒";
		return result;
	}

}
