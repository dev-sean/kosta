package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	// sqlMapConfig.xml�� ȯ�漳���� �����ؼ� �����(SqlClient)�鿡��
	// ���޼��带 �������ְ�, �������� ���޵� ���� ���� �����ִ� �� �ϰ����� �۾��� ���� �� �� �ֵ���
	// SqlSession��ü�� �����ϴ� SqlSessionFactory��ü�� �̱������� �����Ѵ�.
	private static SqlSessionFactory factory;
	static {
		// config/sqlMapConfig.xml�� ������ �о� �´�.
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			//factory ����
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(reader != null)reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Ŭ���̾�Ʈ�� ����� SqlSessionFactory�� �����ϴ� �޼��� ����
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}