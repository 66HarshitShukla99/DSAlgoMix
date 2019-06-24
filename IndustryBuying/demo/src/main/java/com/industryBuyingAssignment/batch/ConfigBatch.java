package com.industryBuyingAssignment.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.industryBuyingAssignment.model.Model;
import com.industryBuyingAssignment.processor.ModelItemProcessor;

@Configuration
@EnableBatchProcessing
public class ConfigBatch {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public DataSource dataSource;
	
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/springbatch");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	 public FlatFileItemReader<Model> reader(){
	  FlatFileItemReader<Model> reader = new FlatFileItemReader<Model>();
	  reader.setResource(new ClassPathResource("cunique.csv"));
	  reader.setLineMapper(new DefaultLineMapper<Model>() {{
	   setLineTokenizer(new DelimitedLineTokenizer() {{
	    setNames(new String[] { "name" });
	   }});
	   setFieldSetMapper(new BeanWrapperFieldSetMapper<Model>() {{
	    setTargetType(Model.class);
	   }});
	   
	  }});
	  
	  return reader;
	 }
	 
	 @Bean
	 public ModelItemProcessor processor(){
	  return new ModelItemProcessor();
	 }
	 
	 @Bean
	 public JdbcBatchItemWriter<Model> writer(){
	  JdbcBatchItemWriter<Model> writer = new JdbcBatchItemWriter<Model>();
	  writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Model>());
	  writer.setSql("INSERT INTO user(name) VALUES (:name)");
	  writer.setDataSource(dataSource);
	  
	  return writer;
	 }
	 
	 @Bean
	 public Step step1() {
	  return stepBuilderFactory.get("step1").<Model, Model> chunk(3)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer())
	    .build();
	 }
	 
	 @Bean
	 public Job importUserJob() {
	  return jobBuilderFactory.get("importUserJob")
	    .incrementer(new RunIdIncrementer())
	    .flow(step1())
	    .end()
	    .build();
	 }
	
}
