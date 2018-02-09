package org.springframework.samples.petclinic.audit;

import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Iliya on 9.2.2018 г..
 */

@Entity
@Table(name = "audit")
public class User extends BaseEntity{

    @Column(name = "username")
    @AuditingTargetUsername
    private String username;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "action")
    private String action;

    @Column(name = "target_user")
    private String targetUser;
}
