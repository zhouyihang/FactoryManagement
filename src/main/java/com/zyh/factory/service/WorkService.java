package com.zyh.factory.service;

import com.zyh.factory.entity.WorkEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public interface WorkService {

	WorkEntity create(TransMessage transMessage, WorkEntity work);

}
