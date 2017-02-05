/**
 * 
 */
package com.bong.component.backend.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bong.component.backend.server.repository.UserRepository;
import com.bong.component.model.User;
import com.bong.component.service.UserService;

/**
 * <pre>
 * 
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	/**
	 * 
	 */
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.bong.component.service.CRUDService#getOne(java.io.Serializable)
	 */
	@Override
	public User getOne(Integer id) {
		
		return userRepo.findOne(id);
	}

	@Transactional
	public User save(User entity) {
		User user = userRepo.save(entity);
		
		LOGGER.debug("saved!! {}", user);
		
		return user;
	}

	/* (non-Javadoc)
	 * @see com.bong.component.service.CRUDService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bong.component.service.CRUDService#delete(java.lang.Object)
	 */
	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

}
