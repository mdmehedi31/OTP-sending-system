package com.nf.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbAddWork")
public class AddWork implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "mailId")
    private String mailId;

    @Column(name = "subTitle")
    private String subTitle;

    @Column(name = "mailTopic")
    private String mailTopic;

    @Column(name = "mailDate")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String mailDate;
}
