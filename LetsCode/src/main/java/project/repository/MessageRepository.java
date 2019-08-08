package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.entity.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);

}
