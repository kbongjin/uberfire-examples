/**
 * 
 */
package com.bong.component.base;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * <pre>
 * 
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
public interface CRUDService<T, ID extends Serializable> extends RemoteService {
	
	T getOne(ID id);
	
	T save(T entity);
	
	void delete(ID id);
	
	void delete(T entity);
	
}
