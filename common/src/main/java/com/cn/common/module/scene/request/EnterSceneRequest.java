package com.cn.common.module.scene.request;

import com.cn.common.core.serial.Serializer;

public class EnterSceneRequest extends Serializer{
	
	/**
	 * 场景id
	 */
	private short sceneId;
	
	private String sceneName;
	

	public short getSceneId() {
		return sceneId;
	}

	public void setSceneId(short sceneId) {
		this.sceneId = sceneId;
	}

	
	@Override
	protected void read() {
		this.sceneId=readShort();
		this.sceneName=readString();
	}

	@Override
	protected void write() {
		writeShort(sceneId);
		writeString(sceneName);
	}

}
