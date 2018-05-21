package io.rajdeep.quickstart.topic;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<TopicDTO> getAllTopics(){
		System.out.println("GET CALLED");
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "/topics", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO addTopic(@Valid @RequestBody TopicDTO topic) {
		ResponseDTO responseDTO = new ResponseDTO(ResponseDTO.Status.SUCCESS,
				"Topic Added");
//		try {
			topicService.addTopic(topic);
//		} catch (Exception e) {
//			responseDTO.setStatus(ResponseDTO.Status.FAIL);
//			responseDTO.setMessage(e.getMessage());
//		}
		return responseDTO;
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/topics")
//	public void addTopic(@RequestBody Topic topic){
//		topicService.addTopic(topic);
//	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id){
		return topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public String deleteTopic(@PathVariable String id){
		return topicService.deleteTopic(id);
	}
	
}
