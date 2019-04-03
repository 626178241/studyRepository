package lb.study.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

/**
 * Optional ����Ҫ����������ǳ��������Ŀ�ָ���쳣��NullPointerException
 * 
 * ���͵�ַ��http://www.cnblogs.com/zhangboyu/p/7580262.html
 * @author LB
 * @date 2018��12��19��  ����10:25:38
 */
public class Test_01 {

	/**
	 * ��ǰ��д����Ϊ�˷�ֹ��ָ��ÿ�ζ���Ҫ�ж�
	 * 
	 * @date 2018��12��19��  ����10:30:40
	 */
	@SuppressWarnings("unused")//ȥ������
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
	 * ������͵Ķ�����ܰ���ֵ��Ҳ����Ϊ�ա������ʹ��ͬ����������һ���յ� Optional��
	 * 
	 * @date 2018��12��19��  ����10:39:15
	 */
	@Test
	public void whenCreateEmptyOptional_thenNull() {
		Optional<User> optional = Optional.empty();
		optional.get();//Ϊ��  ������NoSuchElementException�쳣
	}
	
	/**
	 * of() �� ofNullable() ������������ֵ�� Optional��
	 * ���������Ĳ�֮ͬ������������ null ֵ��Ϊ�������ݽ�ȥ��of() �������׳� NullPointerException��
	 * ��ˣ���Ӧ����ȷ����Ϊ null  ��ʱ��ʹ�� of()��
	 * ������󼴿����� null Ҳ�����Ƿ� null�����Ӧ��ʹ�� ofNullable() ����
	 * @date 2018��12��19��  ����10:44:12
	 */
	@Test
	public void whenCreateOfEmptyOptional_thenNullPointerException() {
		User user1 = null;
		User user2 = new User();
		Optional<User> of = Optional.of(user2);//���Ϊ�վͻᱨ�쳣
		Optional<User> ofNullable = Optional.ofNullable(user1);//�������Ϊ��Ҳ�����쳣
	}
	
	/**
	 * ʹ��get()��ȡ��������ֵ֤isPresent()��ifPresent() ����
	 * ifPresent():�÷�������ִ�м�飬������һ��Consumer(������) ��������������ǿյģ��Ͷ�ִ�д���� Lambda ���ʽ
	 * @date 2018��12��19��  ����10:48:20
	 */
	@Test
	public void whenCheckIfPresent_thenOk() {
		User user1 = null;
		User user2 = new User("����","libo");
		Optional<User> ofNullable = Optional.ofNullable(user2);//�������Ϊ��Ҳ�����쳣
		if(ofNullable.isPresent()) {
			User u = ofNullable.get();
			System.out.println(u);
		}
		ofNullable.ifPresent(u -> System.out.println(u.getName()));//�����Ϊ�գ����������
	}
	
	/**
	 * ����Ĭ��ֵʹ��orElse(o)��orElseGet(o)
	 * 
	 * @date 2018��12��19��  ����10:56:54
	 */
	@Test
	public void whenEmptyValue_thenReturnDefault() {
		User user1 = null;
		User user2 = new User("����","libo");
		User user3 = new User("����","cc");
		User u = Optional.ofNullable(user3).orElse(user2);//���user3Ϊ�գ��򷵻�user2
		System.out.println(u);
		User u2 = Optional.ofNullable(user3).orElseGet(() -> user2);//���user3Ϊ�գ��򷵻�user2
		//����
		User u21 = Optional.ofNullable(user3).orElse(createNewUser());//����user3��Ϊ�գ�һ�������createNewUser()����
		System.out.println(u);
		User u22 = Optional.ofNullable(user3).orElseGet(() -> createNewUser());//���user3Ϊ�գ��������createNewUser()����
	}
	
	private User createNewUser() {
		System.out.println("Creating New User");
	    return new User("����", "1234");
	}
	
	/**
	 * �кܶ��ַ�������ת�� Optional  ��ֵ�����Ǵ� map() �� flatMap() ������ʼ��
	 * 
	 * @date 2018��12��19��  ����11:16:01
	 */
	@Test
	public void whenMap_thenOk() {
		User user0 = null;
		User user = new User("guiyang", "1234");
	    User user1 = new User();
	    //���u.getName()Ϊ�գ��򷵻ء�4567��
	    String name = Optional.ofNullable(user1).map(u ->u.getName()).orElse("4567");
	    System.out.println(name);
	    System.out.println(user1);//û�иı����
	}
	
	
}
