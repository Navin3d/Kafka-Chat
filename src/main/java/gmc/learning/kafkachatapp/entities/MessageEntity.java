package gmc.learning.kafkachatapp.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "message_history")
public class MessageEntity implements Serializable {

	private static final long serialVersionUID = 3169792645064365866L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "sent_at")
	private Timestamp sentAt;

}
