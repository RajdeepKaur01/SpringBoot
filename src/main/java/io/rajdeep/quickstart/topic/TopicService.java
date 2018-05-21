package io.rajdeep.quickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	// This annotation make class a Business Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "Spring Framework", "Spring Description"),
//			new Topic("java", "Core Java", "Java Description"),
//			new Topic("js", "JavaScript", "Js Description")));

	public List<TopicDTO> getAllTopics(){
		// return topics;
//		List<Topic> topics = new ArrayList<>();
//		topics = topicRepository.findAll();
//		System.out.println("length"+topics.size()+":::"+topicRepository.count());
//		for(Topic t:topics)
//			System.out.println(t.getName()+"here");
//		return topics;
		List<Topic> todoEntries = topicRepository.findAll();
		List<TopicDTO>  dto = new ArrayList<>();
		for(Topic t: todoEntries){
			dto.add(convertToDTO(t));
		}
		return dto;
	}
	
	public Topic getTopic(String id){
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Topic> op = topicRepository.findById(id);
		if(op.isPresent()){
			return op.get();
		}
		return null;
	}
	
	public void addTopic(@Valid TopicDTO topic){
//		topics.add(topic);
//		Optional<Topic> dbMember = topicRepository.findById(topic.getId());
//
//		if (dbMember.get() != null) {
//		System.out.println("Topic exist");
//		return;
//		}
		Topic final_topic = DTOToDomainTransformer.transform(topic);
		topicRepository.save(final_topic);
//		topicRepository.save(topic);
	}
	
	public String updateTopic(Topic topic, String id){
//		for(int i=0;i<topics.size();i++){
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)){
//				topics.set(i, topic);
//				return "Success!!";
//			}
//		}
		topicRepository.save(topic);
		return "Success!!";
	}

	public String deleteTopic(String id) {
		
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
		return "Success!!";
	}
	
	private TopicDTO convertToDTO(Topic model) {
       TopicDTO dto = new TopicDTO();
 
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
 
        return dto;
    }
}
