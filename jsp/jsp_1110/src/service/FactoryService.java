package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
		
		private static SqlSessionFactory factory;
		static {	
			try {
				Reader reader =
						Resources.getResourceAsReader("config/sqlMapConfig.xml");
				factory = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}

		public static SqlSessionFactory getFactory(){
			return factory;
		}
		
		
}
