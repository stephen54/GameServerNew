package com.cn.server.module.scene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.common.module.scene.response.SceneResponse;
import com.cn.server.module.player.dao.PlayerDao;
import com.cn.server.module.player.entity.Player;

@Component
public class SceneServiceImpl implements SceneService {

	@Autowired
	private PlayerDao playerDao;

	@Override
	public SceneResponse changeScene(long playerId, int sceneId) {
		Player player = playerDao.getPlayerById(playerId);
		player.tryChangeScene(sceneId);

		return null;
	}

}
