package com.cn.server.module.scene.service;

import com.cn.common.module.scene.response.SceneResponse;

public interface SceneService {
	
	/**
	 * 用户改变场景
	 */
	public void changeScene(long playerId ,short sceneId);
	
	
	/**
	 * 显示当前场景歌
	 */
	public void showScene(long playerId, short sceneId);
	
	
	

}
