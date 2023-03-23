package net.primera.springboot.entity;

import java.time.LocalDateTime;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
    @CreatedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'", updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'")
    protected LocalDateTime lastModifiedDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
//	
//	@Temporal(TemporalType.DATE)
//	@CreatedDate
//	private Date createdDate;
//	
//	@Temporal(TemporalType.DATE)
//	@LastModifiedDate
//	private Date lastModifiedDate;
	
//	public LocalDateTime getCreatedDate() {
//		return CreatedDate;
//	}
//
//	public void setCreatedDate(LocalDateTime createdDate) {
//		CreatedDate = createdDate;
//	}
//
//	public LocalDateTime getUpdatedDate() {
//		return UpdatedDate;
//	}
//
//	public void setUpdatedDate(LocalDateTime updatedDate) {
//		UpdatedDate = updatedDate;
//	}

}
