package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		/*
		G 年代标志符
		y 年
		M 月
		d 日
		h 时 在上午或下午 (1~12)
		H 时 在一天中 (0~23)
		m 分
		s 秒
		S 毫秒
		E 星期
		D 一年中的第几天
		F 一月中第几个星期几
		w 一年中第几个星期
		W 一月中第几个星期
		a 上午 / 下午 标记符
		k 时 在一天中 (1~24)
		K 时 在上午或下午 (0~11)
		z 时区
		*/
		Date date = new Date();
		String str = "1990-01-31 17:10:59";
		SimpleDateFormat fm = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
		SimpleDateFormat fm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fm.format(fm1.parse(str)));
		System.out.println(fm.format(date));
	}

}
