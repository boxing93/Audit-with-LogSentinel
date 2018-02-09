package org.springframework.samples.petclinic.audit;


import com.logsentinel.auth.Authentication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Auditable;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
import java.security.Timestamp;

/**
 * Created by Iliya on 9.2.2018 г..
 */

@Aspect
public class AuditingAspect {

    private Authentication authentication;

    @Autowired
    public AuditingAspect(Authentication authentication) {
        this.authentication = authentication;
    }

    @After("@annotation(auditable)")
    @Transactional
    public void logAuditActivity(JoinPoint jp, Auditable auditable) {
        String targetAuditingUser;
        String actionType = auditable.actionType().getDescription();
        String auditingUsername = authentication.applyToParams();
    }

}
}
