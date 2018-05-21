package io.rajdeep.quickstart.course;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CourseRepository extends MongoRepository<Course, String> {
	
//	public List<Course> getCoursesByName(String name);
	public List<Course> findByName(String name);
//	@Query("{'topic.id': ?0}")
	public List<Course> findByTopicId(String topicId);

	
}
