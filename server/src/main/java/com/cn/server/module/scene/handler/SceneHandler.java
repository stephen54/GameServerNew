package com.cn.server.module.scene.handler;
/**
 *场景
 */

import com.cn.common.core.annotion.SocketCommand;
import com.cn.common.core.annotion.SocketModule;
import com.cn.common.core.model.Result;
import com.cn.common.module.ModuleId;
import com.cn.common.module.scene.SceneCmd;

@SocketModule(module=ModuleId.SCENE)
public interface SceneHandler {
	
	/**
	 * 显示当前场景
	 */
	@SocketCommand(cmd=SceneCmd.CURSCENE)
	public Result<?> showScene(long playerId,byte[] data);

	/**
	 * 改变场景
	 */
	@SocketCommand(cmd=SceneCmd.CHANGESCENE)
	public Result<?> changeScene(long playerId, byte[] data);
}
