package com.cn.server.module.scene.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cn.common.core.exception.ErrorCodeException;
import com.cn.common.core.model.Result;
import com.cn.common.core.model.ResultCode;
import com.cn.common.module.scene.request.EnterSceneRequest;
import com.cn.common.module.scene.request.ShowSceneRequest;
import com.cn.common.module.scene.response.SceneResponse;
import com.cn.server.module.player.dao.PlayerDao;
import com.cn.server.module.player.entity.Player;
import com.cn.server.module.scene.service.SceneService;

@Component
public class SceneHandlerImpl implements SceneHandler {

	@Autowired
	private SceneService sceneService;
	@Autowired
	private PlayerDao playerDao;

	@Override
	public Result<?> showScene(long playerId, byte[] data) {
		try {
			// 反序列化
			ShowSceneRequest showSceneRequest = new ShowSceneRequest();
			showSceneRequest.readFromBytes(data);
			Player player = playerDao.getPlayerById(playerId);

			// 参数判空
			if (StringUtils.isEmpty(player)) {
				return Result.ERROR(ResultCode.PLAYER_NO_EXIST);
			}
			if (StringUtils.isEmpty(showSceneRequest.getSceneId()) && player.getSceneId() == 0) {
				return Result.ERROR(ResultCode.SCENE_ID_IS_NULL);
			}
			// 执行业务
			sceneService.showScene(playerId, player.getSceneId());
		} catch (ErrorCodeException e) {
			return Result.ERROR(e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.ERROR(ResultCode.UNKOWN_EXCEPTION);
		}
		return Result.SUCCESS();
	}

	@Override
	public Result<?> changeScene(long playerId, byte[] data) {
		SceneResponse result = null;
		try {
			// 反序列化
			EnterSceneRequest enterSceneRequest = new EnterSceneRequest();
			enterSceneRequest.readFromBytes(data);

			Player player = playerDao.getPlayerById(playerId);

			// 参数判空
			if (StringUtils.isEmpty(player)) {
				return Result.ERROR(ResultCode.PLAYER_NO_EXIST);
			}
			if (StringUtils.isEmpty(enterSceneRequest.getSceneId()) && enterSceneRequest.getSceneId() == 0) {
				return Result.ERROR(ResultCode.SCENE_ID_IS_NULL);
			}
			// 执行业务
			result = sceneService.changeScene(playerId, player.getSceneId());
		} catch (ErrorCodeException e) {
			return Result.ERROR(e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.ERROR(ResultCode.UNKOWN_EXCEPTION);
		}
		return Result.SUCCESS(result);
	}

}
