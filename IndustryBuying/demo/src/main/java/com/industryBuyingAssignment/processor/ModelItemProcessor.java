package com.industryBuyingAssignment.processor;


import org.springframework.batch.item.ItemProcessor;
import com.industryBuyingAssignment.model.Model;

	

	public class ModelItemProcessor implements ItemProcessor<Model, Model> {

	 @Override
	 public Model process(Model model) throws Exception {
	  return model;
	 }

	} 

