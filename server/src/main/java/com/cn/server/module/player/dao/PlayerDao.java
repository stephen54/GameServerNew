package com.cn.server.module.player.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.cn.server.module.player.entity.Player;
import com.cn.server.module.scene.entity.SceneId;
/**
 * 玩家dao
 *
 */
@Component
public class PlayerDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 获取玩家通过id
	 * @param playerId
	 * @return
	 */
	public Player getPlayerById(long playerId){
		return hibernateTemplate.get(Player.class, playerId);
	}
	
	
	
	/**
	 * 获取玩家通过玩家名
	 * @param playerName
	 * @return
	 */
	public Player getPlayerByName(final String playerName){
		
		return hibernateTemplate.execute(new HibernateCallback<Player>() {

			@Override
			public Player doInHibernate(Session session)throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery("SELECT * FROM player where playerName = ?");
				query.setString(0, playerName);
				query.addEntity(Player.class);
				
				@SuppressWarnings("unchecked")
				List<Player> list = query.list();
				if(list==null || list.isEmpty()){
					return null;
				}
				return list.get(0);
			}
		});
	}
	
	
	/**
	 * 创建玩家
	 * @param player
	 * @return
	 */
	public Player createPlayer(Player player){
		long playerId = (Long) hibernateTemplate.save(player);
		player.setPlayerId(playerId);
		player.setSceneId(SceneId.QI_SHI_ZHI_DI);
		hibernateTemplate.update(player);
		System.out.println("创建玩家的场景id++++"+player.getSceneId());
		return player;
	}
	
	public void tryChangeScene(Player player,short sceneId) {
		player.setSceneId(sceneId);
		hibernateTemplate.update(player);
	}

}
