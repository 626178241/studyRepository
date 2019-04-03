package 取近一个月的日期;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class TestMouth {
	
	@Test
	public static void test() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 15);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		System.out.println(str);
	}

	@Test
	public static void test2() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 15);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		System.out.println(str);
	}
	
	@Test
	public static void test3() {
		Map map = new HashMap<>();
		map.put("id", null);
		//long l = Long.parseLong(String.valueOf(map.get("id")));
		//long l = (Long)map.get("id");
		System.out.println(String.valueOf(map.get("id")));
		//System.out.println(l);
	}
	
	@Test
	public static void test4() {
		Map map = new HashMap<>();
		Map map0 = new LinkedHashMap<>();
		map = map0;
		System.out.println(map.getClass());
	}
	
	public static void main(String[] args) {
		test4();
		/*Long a= 42L;
		Long b= 65L;
		Double c = Double.valueOf(a);
		System.out.println(c/b);
		Double d = Double.valueOf(b);
		System.out.println(a/d);*/
	}
}
