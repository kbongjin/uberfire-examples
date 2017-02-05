/**
 * 
 */
package com.bong.component.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jboss.errai.common.client.api.annotations.Portable;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * <pre>
 * 
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Portable
@Entity
public class User implements IsSerializable {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String loginId;
	
	private String passwd;

	
	public User() {
		
	}


	public User(Integer id, String name, String loginId, String passwd) {
		this.id = id;
		this.name = name;
		this.loginId = loginId;
		this.passwd = passwd;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", loginId=" + loginId + ", passwd=" + passwd + "]";
	}

}
