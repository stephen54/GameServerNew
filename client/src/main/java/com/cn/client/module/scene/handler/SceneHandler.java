package com.cn.client.module.scene.handler;

import com.cn.common.core.annotion.SocketCommand;
import com.cn.common.core.annotion.SocketModule;
import com.cn.common.module.ModuleId;
import com.cn.common.module.scene.SceneCmd;

@SocketModule(module = ModuleId.SCENE)
public interface SceneHandler {

	/**
	 * 玩家展现当前场景
	 */
	@SocketCommand(cmd = SceneCmd.CURSCENE)
	public void showCurScene(int resultCode, byte[] data);

	/**
	 * 改变场景
	 */
	@SocketCommand(cmd = SceneCmd.ENTER)
	public void changeScene(int resultCode, byte[] data);

}
