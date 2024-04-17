package semi.climbing.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MybatisTemplate {
	public static SqlSession getSqlSession() {
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
				
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			sqlSession = sqlSessionFactory.openSession();
//			result = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
}
