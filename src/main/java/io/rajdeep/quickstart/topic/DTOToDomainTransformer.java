package io.rajdeep.quickstart.topic;

public class DTOToDomainTransformer {
	
	public static Topic transform(final TopicDTO memberDTO) {
		return new Topic(memberDTO.getId(), memberDTO.getName(), memberDTO.getDescription());
	}
}
