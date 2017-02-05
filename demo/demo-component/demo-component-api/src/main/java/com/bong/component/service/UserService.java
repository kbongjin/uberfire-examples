/**
 * 
 */
package com.bong.component.service;

import com.bong.component.base.CRUDService;
import com.bong.component.model.User;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * <pre>
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@RemoteServiceRelativePath("rpc/UserService")
public interface UserService extends CRUDService<User, Integer> {

}
