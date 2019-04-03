package 元注解;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 博客地址：https://blog.csdn.net/initphp/article/details/37041975
 * 自定义注解接口
 * @author LB
 * 2018年10月24日  下午5:40:56
 */
@Documented //申明文档化
@Retention(RetentionPolicy.RUNTIME) //在运行时可以获取
@Target(value= {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD}) //作用于类 、接口，方法,属性/域中
@Inherited //子类会继承 
public @interface UserNameAnnotations {

	public String value() default ""; ////使用的时候 @UserNameAnnotations(value="xxx") 默认""
	
	//定义枚举类型
	public enum MethodEnums{
		TYPE1,TYPE2
	}
	
	public MethodEnums type() default MethodEnums.TYPE1;
}
