package com.cg.dynamodb.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cg.dynamodb.model.Student;

@Repository
public class DynamodbRepository {

	@Autowired
	private DynamoDBMapper mapper;

	public void insertintoDynamodb(Student student) {
		mapper.save(student);
	}

	public Student getOneStudentDetails(String studentId, String lastName) {
		return mapper.load(Student.class, studentId, lastName);
	}

	public void updatedetails(Student student) {
		try {
			mapper.save(student, buildDynamoDBsaveExpression(student));
		} catch (ConditionalCheckFailedException e) {
			e.printStackTrace();
		}
	}

	public void deletedetails(Student student) {
		mapper.save(student);
	}

	public DynamoDBSaveExpression buildDynamoDBsaveExpression(Student student) {
		DynamoDBSaveExpression SaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("studentId", new ExpectedAttributeValue(new AttributeValue(student.getStudentId()))
				.withComparisonOperator(ComparisonOperator.EQ));
		SaveExpression.setExpected(expected);
		return SaveExpression;
	}

}
