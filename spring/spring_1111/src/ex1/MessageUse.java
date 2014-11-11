package ex1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MessageUse {
	public static void main(String[] args) {
		//xml�� �о�;� �ϴµ�...
		Resource resource = new ClassPathResource("ex1/ex1_img.xml");
		System.out.println("Resource:"+resource);
		//�����̳ʿ� ex1_img.xml�� ���ǵ� ���� ����� ����
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("Factory :" + factory);
		/*
		//�����̳ʿ� ������ ���� ����
		Ex1_MessageApp bean = factory.getBean("msg",Ex1_MessageApp.class);
		System.out.println("Result :"+bean.printMsg());
		*/
		TodayApps bean = factory.getBean("today", TodayApps.class);
		System.out.println("Result :"+bean.printDate());
		
		//�ڹ��ڵ�� ����
	}
}
