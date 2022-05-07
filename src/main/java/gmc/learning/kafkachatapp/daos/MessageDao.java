package gmc.learning.kafkachatapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.learning.kafkachatapp.entities.MessageEntity;

public interface MessageDao extends JpaRepository<MessageEntity, String> {

}
