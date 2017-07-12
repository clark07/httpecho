package com.cs.test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by chensheng350 on 2017/7/7.
 */
public class ValidateDemo {


	    public static void main(String[] args){
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

			Validator validator = factory.getValidator();


			ValidateBean validateBean = new ValidateBean();
			validateBean.setAge(30);
			Set<ConstraintViolation<ValidateBean>> validate = validator.validate(validateBean);

			validate.forEach(cv->{

				System.out.println(cv.getMessage());
			});



		}
}
