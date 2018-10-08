package com.cn.common.module.scene.request;

import com.cn.common.core.serial.Serializer;

public class EnterSceneRequest extends Serializer{
	
	/**
	 * 用户名
	 */
	private int sceneId;
	
	private String sceneName;
	

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	@Override
	protected void read() {
		this.sceneId=readInt();
		this.sceneName=readString();
	}

	@Override
	protected void write() {
		writeInt(sceneId);
		writeString(sceneName);
	}

}
