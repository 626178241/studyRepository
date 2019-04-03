package lb.study.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

/**
 * Optional 类主要解决的问题是臭名昭著的空指针异常（NullPointerException
 * 
 * 博客地址：http://www.cnblogs.com/zhangboyu/p/7580262.html
 * @author LB
 * @date 2018年12月19日  上午10:25:38
 */
public class Test_01 {

	/**
	 * 以前的写法，为了防止空指针每次都需要判断
	 * 
	 * @date 2018年12月19日  上午10:30:40
	 */
	@SuppressWarnings("unused")//去掉警告
	@Test
	public void testBefore() {
		User user = null;
		//String name = user.getName();
		String name = null;
		if(user!=null) {
			name = user.getName();
		}
	}
	
	/**
	 * 这个类型的对象可能包含值，也可能为空。你可以使用同名方法创建一个空的 Optional。
	 * 
	 * @date 2018年12月19日  上午10:39:15
	 */
	@Test
	public void whenCreateEmptyOptional_thenNull() {
		Optional<User> optional = Optional.empty();
		optional.get();//为空  会引发NoSuchElementException异常
	}
	
	/**
	 * of() 和 ofNullable() 方法创建包含值的 Optional。
	 * 两个方法的不同之处在于如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException：
	 * 因此，你应该明确对象不为 null  的时候使用 of()。
	 * 如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法
	 * @date 2018年12月19日  上午10:44:12
	 */
	@Test
	public void whenCreateOfEmptyOptional_thenNullPointerException() {
		User user1 = null;
		User user2 = new User();
		Optional<User> of = Optional.of(user2);//这个为空就会报异常
		Optional<User> ofNullable = Optional.ofNullable(user1);//这个就算为空也不会异常
	}
	
	/**
	 * 使用get()获取对象，先验证值isPresent()、ifPresent() 方法
	 * ifPresent():该方法除了执行检查，还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式
	 * @date 2018年12月19日  上午10:48:20
	 */
	@Test
	public void whenCheckIfPresent_thenOk() {
		User user1 = null;
		User user2 = new User("郴州","libo");
		Optional<User> ofNullable = Optional.ofNullable(user2);//这个就算为空也不会异常
		if(ofNullable.isPresent()) {
			User u = ofNullable.get();
			System.out.println(u);
		}
		ofNullable.ifPresent(u -> System.out.println(u.getName()));//如果不为空，则输出属性
	}
	
	/**
	 * 返回默认值使用orElse(o)、orElseGet(o)
	 * 
	 * @date 2018年12月19日  上午10:56:54
	 */
	@Test
	public void whenEmptyValue_thenReturnDefault() {
		User user1 = null;
		User user2 = new User("郴州","libo");
		User user3 = new User("郴州","cc");
		User u = Optional.ofNullable(user3).orElse(user2);//如果user3为空，则返回user2
		System.out.println(u);
		User u2 = Optional.ofNullable(user3).orElseGet(() -> user2);//如果user3为空，则返回user2
		//区别
		User u21 = Optional.ofNullable(user3).orElse(createNewUser());//就算user3不为空，一样会调用createNewUser()方法
		System.out.println(u);
		User u22 = Optional.ofNullable(user3).orElseGet(() -> createNewUser());//如果user3为空，不会调用createNewUser()方法
	}
	
	private User createNewUser() {
		System.out.println("Creating New User");
	    return new User("桂阳", "1234");
	}
	
	/**
	 * 有很多种方法可以转换 Optional  的值。我们从 map() 和 flatMap() 方法开始。
	 * 
	 * @date 2018年12月19日  上午11:16:01
	 */
	@Test
	public void whenMap_thenOk() {
		User user0 = null;
		User user = new User("guiyang", "1234");
	    User user1 = new User();
	    //如果u.getName()为空，则返回‘4567’
	    String name = Optional.ofNullable(user1).map(u ->u.getName()).orElse("4567");
	    System.out.println(name);
	    System.out.println(user1);//没有改变对象
	}
	
	
}
