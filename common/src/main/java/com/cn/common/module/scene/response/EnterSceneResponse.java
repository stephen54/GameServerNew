package com.cn.common.module.scene.response;

import com.cn.common.core.serial.Serializer;

public class EnterSceneResponse extends Serializer {

	/**
	 * 场景id
	 */
	private int playerId;

	/**
	 * 场景名
	 */
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
		this.playerId=readInt();
		this.sceneId=readShort();
	}

	@Override
	protected void write() {
		writeInt(this.playerId);
		writeShort(this.sceneId);
	}

}
