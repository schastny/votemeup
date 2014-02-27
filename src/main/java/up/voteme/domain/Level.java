package up.voteme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL")

public class Level {

	@Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "LEVEL")
    private String level;	

    @Column(name = "MinVoteYes")
    private String MinVoteYes;	
    
	
}
