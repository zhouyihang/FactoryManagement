package com.zyh.factory.service;

import com.zyh.factory.entity.SourceEntity;
import com.zyh.factory.transman.TransMessage;

/**
 * @author Yihang
 *
 */
public interface SourceService {

	SourceEntity create(TransMessage transMessage, SourceEntity source);

	SourceEntity update(TransMessage message, SourceEntity source);

}
