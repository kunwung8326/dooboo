package com.koreait.dooboo.member.config;



import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.koreait.dooboo.member.command.DeleteCommand;
import com.koreait.dooboo.member.command.IdCheckCommand;
import com.koreait.dooboo.member.command.JoinCommand;
import com.koreait.dooboo.member.command.LoginCommand;
import com.koreait.dooboo.member.command.UpdateCommand;
import com.koreait.dooboo.member.command.UpdateCommand2;
import com.koreait.dooboo.member.command.UpdateCommand3;
import com.koreait.dooboo.member.command.UpdateCommand4;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		hikariConfig.setUsername("spring");
		hikariConfig.setPassword("1111");
		return hikariConfig;
	}
	/* HiKari(DBCP) */
	@Bean
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	/* SqlSessionFactory */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(hikariDataSource());
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/koreait/dooboo/member/dao/*.xml"));
		return sqlSessionFactory.getObject();
	}
	/* SqlSession */
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean 
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}
	@Bean
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	
	@Bean
	public UpdateCommand updateCommand() {
		return new UpdateCommand();
	}
	@Bean
	public UpdateCommand2 updateCommand2() {
		return new UpdateCommand2();
	}
	@Bean
	public UpdateCommand3 updateCommand3() {
		return new UpdateCommand3();
	}
	@Bean
	public UpdateCommand4 updateCommand4() {
		return new UpdateCommand4();
	}
	@Bean
	public DeleteCommand deleteCommand() {
		return new DeleteCommand();
	}
	public IdCheckCommand idCheckCommand() {
		return new IdCheckCommand();
	}
	
	 
}