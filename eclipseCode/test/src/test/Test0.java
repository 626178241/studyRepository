package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test0 {
	
	public static void main(String[] args) {
		/*Map map = new HashMap();
		System.out.println(map.get(null));		*/
		new Test0();
		Long l1 = 127L;
		Long l2 = 127L;
		System.out.println(l1==l2);
	}

	@Test
	public void test01() {
		Map map = new HashMap();
		map.put(1, "1");
		System.out.println(map.get(1));
		map.put(1, "2");
		System.out.println(map.get(1));
	}
	
	@Test
	public void test02() {
		Integer i = 1;
		long l = i;
		Long L = (long)i;
		Long ll =Long.valueOf(i);
		System.out.println(ll);
	}
	
	@Test
	public void test03() {
		List l1 = new ArrayList<>();
		l1.add(new Long(1));
		l1.add(new Long(2));
		l1.add(new Long(3));
		l1.add(new Long(130));
		
		System.out.println(l1.contains(new Long(130)));
		System.out.println("1".equals(new Long(1).toString()));
		System.out.println(new Long(150).equals(new Long(150)));
	}

	@Test
	public void test04(){
		Long l = 0L;
		List list = new ArrayList();
		list.forEach(o -> {

		});
		System.out.println(l);
	}
}
