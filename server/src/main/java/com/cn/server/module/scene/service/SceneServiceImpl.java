package com.cn.server.module.scene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.common.core.exception.ErrorCodeException;
import com.cn.common.core.model.ResultCode;
import com.cn.common.core.serial.Serializer;
import com.cn.common.core.session.SessionManager;
import com.cn.common.module.ModuleId;
import com.cn.common.module.scene.SceneCmd;
import com.cn.common.module.scene.response.SceneResponse;
import com.cn.server.module.player.dao.PlayerDao;
import com.cn.server.module.player.entity.Player;

@Component
public class SceneServiceImpl implements SceneService {

	@Autowired
	private PlayerDao playerDao;

	@Override
	public SceneResponse changeScene(long playerId, short sceneId) {
		Player player = playerDao.getPlayerById(playerId);
		if(player==null) {
			throw new ErrorCodeException(ResultCode.PLAYER_NO_EXIST);
		}
		player.tryChangeScene(sceneId);

		//创建Response传输对象返回
		SceneResponse sceneResponse =new SceneResponse();
		sceneResponse.setSceneId(player.getSceneId());
		return sceneResponse;
	}

	/**
	 * 显示当前场景
	 */
	@Override
	public void showScene(long playerId, short sceneId) {
		Player player=playerDao.getPlayerById(playerId);
		if(player==null) {
			throw new ErrorCodeException(ResultCode.PLAYER_NO_EXIST);
		}
		//创建Response传输对象返回
		SceneResponse sceneResponse =new SceneResponse();
		sceneResponse.setSceneId(player.getSceneId());
		SessionManager.sendMessage(playerId, ModuleId.SCENE, SceneCmd.CURSCENE, sceneResponse);
	}

}
