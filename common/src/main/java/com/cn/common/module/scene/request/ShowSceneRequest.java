package com.cn.common.module.scene.request;

import com.cn.common.core.serial.Serializer;

public class ShowSceneRequest extends Serializer {

	/**
	 * 场景id
	 */
	private int playerId;

	private short sceneId;

	

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public short getSceneId() {
		return sceneId;
	}

	public void setSceneId(short sceneId) {
		this.sceneId = sceneId;
	}

	@Override
	protected void read() {
		this.playerId = readInt();
		this.sceneId = readShort();

	}

	@Override
	protected void write() {
		writeInt(playerId);
		writeShort(sceneId);
	}

}
