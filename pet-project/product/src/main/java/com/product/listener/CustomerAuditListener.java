package com.product.listener;

import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Configuration
public class CustomerAuditListener extends AuditingEntityListener {
    @Override
    public void setAuditingHandler(ObjectFactory<AuditingHandler> auditingHandler) {
        super.setAuditingHandler(auditingHandler);
    }

    @Override
    @PrePersist
    public void touchForCreate(Object target) {
        AbstractEntityListener object = (AbstractEntityListener) target;
        if (object.getCreatedBy() == null) {
            super.touchForCreate(target);
        } else {
            object.setModifiedBy(object.getCreatedBy());
        }

    }

    @Override
    @PrePersist
    public void touchForUpdate(Object target) {
        AbstractEntityListener object = (AbstractEntityListener) target;
        if (object.getCreatedBy() == null) {
            super.touchForUpdate(target);
        }
        super.touchForUpdate(target);
    }
}
