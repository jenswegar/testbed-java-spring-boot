package fi.wegar.jens.testbedapi.entity;

import fi.wegar.jens.testbedapi.entity.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "question")
public class QuestionEntity extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;
}
