package io.rajdeep.quickstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	// This annotation make class a Business Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "Spring Framework", "Spring Description"),
//			new Topic("java", "Core Java", "Java Description"),
//			new Topic("js", "JavaScript", "Js Description")));

	public List<Course> getAllCourses(String topicId){
		// return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Course> op = courseRepository.findById(id);
		if(op.isPresent()){
			return op.get();
		}
		return null;
	}
	
	public void addCourse(Course course){
//		topics.add(topic);
		courseRepository.save(course);
	}
	
	public String updateCourse(Course course, String id){
//		for(int i=0;i<topics.size();i++){
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)){
//				topics.set(i, topic);
//				return "Success!!";
//			}
//		}
		courseRepository.save(course);
		return "Success!!";
	}

	public String deleteCourse(String id) {
		
//		topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
		return "Success!!";
	}
}
