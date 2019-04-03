package Ԫע��;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ���͵�ַ��https://blog.csdn.net/initphp/article/details/37041975
 * �Զ���ע��ӿ�
 * @author LB
 * 2018��10��24��  ����5:40:56
 */
@Documented //�����ĵ���
@Retention(RetentionPolicy.RUNTIME) //������ʱ���Ի�ȡ
@Target(value= {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD}) //�������� ���ӿڣ�����,����/����
@Inherited //�����̳� 
public @interface UserNameAnnotations {

	public String value() default ""; ////ʹ�õ�ʱ�� @UserNameAnnotations(value="xxx") Ĭ��""
	
	//����ö������
	public enum MethodEnums{
		TYPE1,TYPE2
	}
	
	public MethodEnums type() default MethodEnums.TYPE1;
}
