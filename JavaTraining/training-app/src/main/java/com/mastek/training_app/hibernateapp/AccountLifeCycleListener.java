package com.mastek.training_app.hibernateapp;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AccountLifeCycleListener {

	// public void <name>(Entity e)
	@PrePersist
	public void beforeInsert(Account a) {
		System.out.println("Pre-Persist: "+a);
	}
	
	@PostPersist
	public void afterInsert(Account a) {
		System.out.println("Post-Persist: "+a);
	}
	
	@PreUpdate
	public void beforeUpdate(Account a) {
		System.out.println("Pre-Merge: "+a);
	}
	
	@PostUpdate
	public void afterUpdate(Account a) {
		System.out.println("Post-Merge: "+a);
	}
	@PreRemove
	public void beforeDelete(Account a) {
		System.out.println("Pre-delete: "+a);
	}
	@PostLoad
	public void postLoad(Account a) {
		System.out.println("Post-get: "+a);
	}
}
