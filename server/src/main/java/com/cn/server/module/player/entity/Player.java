package com.cn.server.module.player.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cn.server.module.scene.entity.Scene;

/**
 * 玩家实体对象
 *
 */
@Entity
@Table(name = "player")
public class Player {

	/**
	 * 玩家id
	 */
	@Id
	@GeneratedValue
	private long playerId;

	/**
	 * 玩家名
	 */
	private String playerName;

	/**
	 * 密码
	 */
	private String passward;

	/**
	 * 等级
	 */
	private int level;

	/**
	 * 经验
	 */
	private int exp;

	/**
	 * 场景id
	 */
	private short sceneId;

	/**
	 * 传送前场景id
	 */
	private int lastSceneId;

	/**
	 * 目的场景id
	 */
	private int prepareSceneId;


	public int getLastSceneId() {
		return lastSceneId;
	}

	public void setLastSceneId(int lastSceneId) {
		this.lastSceneId = lastSceneId;
	}

	public int getPrepareSceneId() {
		return prepareSceneId;
	}

	public void setPrepareSceneId(int prepareSceneId) {
		this.prepareSceneId = prepareSceneId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void tryChangeScene(short sceneId) {
		setSceneId(sceneId);
	}

	public short getSceneId() {
		return sceneId;
	}

	public void setSceneId(short sceneId) {
		this.sceneId = sceneId;
	}

}
