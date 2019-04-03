package 元注解;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import 元注解.UserNameAnnotations.MethodEnums;

/**
 * 使用UserNameAnnotations 注解类
 * @author LB
 * @date 2018年10月24日  下午5:50:16
 */
@UserNameAnnotations("libo")
public class DoUserNameAnnotations {
	
	@UserNameAnnotations(value="李波")
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
	 * 测试在class上使用注解
	 * 
	 * @date 2018年10月24日  下午6:07:43
	 */
	@Test
	public void testClass() {
		Class<DoUserNameAnnotations> c = DoUserNameAnnotations.class;
		
		//因为注解是作用于类上面的，所以可以通过isAnnotationPresent来判断是否是一个
		if(c.isAnnotationPresent(UserNameAnnotations.class)) {
			System.out.println("========是UserNameAnnotations类");
			//获取注解对象
			UserNameAnnotations una = c.getAnnotation(UserNameAnnotations.class);
			
			System.out.println(una.value());
		}else{
			System.out.println("不是UserNameAnnotations注解声明");
		}
		
	}
	
	/**
	 * 测试在方法上使用注解
	 * 
	 * @date 2018年10月24日  下午6:08:18
	 */
	@Test
	public void testMethod() throws Exception{
		Class<DoUserNameAnnotations> c = DoUserNameAnnotations.class;
		
		//因为注解是定义在方法上的，所以需要先获取方法对象
		Method method = c.getDeclaredMethod("testMethodAnnotations");
		
		if(c.isAnnotationPresent(UserNameAnnotations.class)) {
			//获取注解对象
			UserNameAnnotations una = method.getAnnotation(UserNameAnnotations.class);
			System.out.println("type="+una.type()+"  ,vlaue="+una.value());
		}
	}
	
	/**
	 * 测试属性声明注解
	 * 接下来通过反射设置name
	 * @date 2018年10月24日  下午6:27:18
	 */
	@Test
	public void testField() throws Exception {
		Class<DoUserNameAnnotations> c = DoUserNameAnnotations.class;
		
		//因为注解是定义在属性当中，所以需要先获取属性对象
		Field field = c.getDeclaredField("name");
		
		if(field.isAnnotationPresent(UserNameAnnotations.class)) {
			//获取注解对象
			UserNameAnnotations una = field.getAnnotation(UserNameAnnotations.class);
			System.out.println("注解的value="+una.value());
			
			//通过反射设置name的值
			//Method fieldMethod = c.getDeclaredMethod("setName");
			
			//创建对象
			DoUserNameAnnotations dob= c.newInstance();
			
			field.set(dob, una.value());
			
			System.out.println("对象的name="+dob.getName());
		}
	}
}
