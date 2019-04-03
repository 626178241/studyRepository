package Ԫע��;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import Ԫע��.UserNameAnnotations.MethodEnums;

/**
 * ʹ��UserNameAnnotations ע����
 * @author LB
 * @date 2018��10��24��  ����5:50:16
 */
@UserNameAnnotations("libo")
public class DoUserNameAnnotations {
	
	@UserNameAnnotations(value="�")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@UserNameAnnotations(type=MethodEnums.TYPE2)
	public void testMethodAnnotations() {
		
	}
	
	/**
	 * ������class��ʹ��ע��
	 * 
	 * @date 2018��10��24��  ����6:07:43
	 */
	@Test
	public void testClass() {
		Class<DoUserNameAnnotations> c = DoUserNameAnnotations.class;
		
		//��Ϊע����������������ģ����Կ���ͨ��isAnnotationPresent���ж��Ƿ���һ��
		if(c.isAnnotationPresent(UserNameAnnotations.class)) {
			System.out.println("========��UserNameAnnotations��");
			//��ȡע�����
			UserNameAnnotations una = c.getAnnotation(UserNameAnnotations.class);
			
			System.out.println(una.value());
		}else{
			System.out.println("����UserNameAnnotationsע������");
		}
		
	}
	
	/**
	 * �����ڷ�����ʹ��ע��
	 * 
	 * @date 2018��10��24��  ����6:08:18
	 */
	@Test
	public void testMethod() throws Exception{
		Class<DoUserNameAnnotations> c = DoUserNameAnnotations.class;
		
		//��Ϊע���Ƕ����ڷ����ϵģ�������Ҫ�Ȼ�ȡ��������
		Method method = c.getDeclaredMethod("testMethodAnnotations");
		
		if(c.isAnnotationPresent(UserNameAnnotations.class)) {
			//��ȡע�����
			UserNameAnnotations una = method.getAnnotation(UserNameAnnotations.class);
			System.out.println("type="+una.type()+"  ,vlaue="+una.value());
		}
	}
	
	/**
	 * ������������ע��
	 * ������ͨ����������name
	 * @date 2018��10��24��  ����6:27:18
	 */
	@Test
	public void testField() throws Exception {
		Class<DoUserNameAnnotations> c = DoUserNameAnnotations.class;
		
		//��Ϊע���Ƕ��������Ե��У�������Ҫ�Ȼ�ȡ���Զ���
		Field field = c.getDeclaredField("name");
		
		if(field.isAnnotationPresent(UserNameAnnotations.class)) {
			//��ȡע�����
			UserNameAnnotations una = field.getAnnotation(UserNameAnnotations.class);
			System.out.println("ע���value="+una.value());
			
			//ͨ����������name��ֵ
			//Method fieldMethod = c.getDeclaredMethod("setName");
			
			//��������
			DoUserNameAnnotations dob= c.newInstance();
			
			field.set(dob, una.value());
			
			System.out.println("�����name="+dob.getName());
		}
	}
}
