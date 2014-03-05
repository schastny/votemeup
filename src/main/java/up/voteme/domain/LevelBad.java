package up.voteme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public enum MinVotePeriod {
    week,
    month,
    quarter;
}

@Entity
@Table(name = "LEVEL")

public class LevelBad {

	@Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "LEVEL")
    private String level;	

    @Column(name = "MinVoteYes")
    private Integer minVoteYes;	
    
    @Column(name = "MinVotePeriod")
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('week','month','quarter')")
    private MinVotePeriod minVotePeriod;	
    

    
}

// http://habrahabr.ru/post/77982/