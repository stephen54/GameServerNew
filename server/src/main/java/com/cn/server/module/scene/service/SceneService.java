package com.cn.server.module.scene.service;

import com.cn.common.module.scene.response.SceneResponse;
import com.cn.server.module.player.entity.Player;

public interface SceneService {
	
	/**
	 * 用户改变场景
	 */
	public SceneResponse changeScene(long playerId ,int sceneId);
	
	
	
	

}
