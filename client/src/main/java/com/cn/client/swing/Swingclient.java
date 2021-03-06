package com.cn.client.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cn.client.Client;
import com.cn.client.swing.constant.ButtonCommand;
import com.cn.common.core.model.Request;
import com.cn.common.module.ModuleId;
import com.cn.common.module.chat.ChatCmd;
import com.cn.common.module.chat.request.PrivateChatRequest;
import com.cn.common.module.chat.request.PublicChatRequest;
import com.cn.common.module.player.PlayerCmd;
import com.cn.common.module.player.request.LoginRequest;
import com.cn.common.module.player.request.RegisterRequest;
import com.cn.common.module.player.response.PlayerResponse;
import com.cn.common.module.scene.SceneCmd;
import com.cn.common.module.scene.request.EnterSceneRequest;
import com.cn.common.module.scene.request.ShowSceneRequest;

@Component
public class Swingclient extends JFrame implements ActionListener {

	@Autowired
	private Client client;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2572235358190956651L;

	/**
	 * 玩家信息
	 */
	private PlayerResponse playerResponse;

	/**
	 * 用户名
	 */
	private JTextField playerName;

	/**
	 * 密码
	 */
	private JTextField passward;

	/**
	 * 场景id
	 */
	private JTextField sceneId;

	/**
	 * 登录按钮
	 */
	private JButton loginButton;

	/**
	 * 注册按钮
	 */
	private JButton register;

	/**
	 * 进入场景按钮
	 */
	private JButton enterScene;

	/**
	 * 显示当前场景
	 */
	private JButton showScene;

	/**
	 * 聊天内容
	 */
	private JTextArea chatContext;

	/**
	 * 场景id
	 */
	private JTextArea sceneIdContext;

	/**
	 * 发送内容
	 */
	private JTextField message;

	/**
	 * 目标用户
	 */
	private JTextField targetPlayer;

	/**
	 * 发送按钮
	 */
	private JButton sendButton;

	/**
	 * 操作提示
	 */
	private JLabel tips;

	public Swingclient() {

		getContentPane().setLayout(null);

		// 登录部分
		JLabel lblIp = new JLabel("角色名");
		lblIp.setFont(new Font("宋体", Font.PLAIN, 12));
		lblIp.setBounds(76, 40, 54, 15);
		getContentPane().add(lblIp);

		playerName = new JTextField();
		playerName.setBounds(139, 37, 154, 21);
		getContentPane().add(playerName);
		playerName.setColumns(10);

		JLabel label = new JLabel("密  码");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(76, 71, 54, 15);
		getContentPane().add(label);

		passward = new JTextField();
		passward.setColumns(10);
		passward.setBounds(139, 68, 154, 21);
		getContentPane().add(passward);

		// 登录
		loginButton = new JButton("登录");
		loginButton.setFont(new Font("宋体", Font.PLAIN, 12));
		loginButton.setActionCommand(ButtonCommand.LOGIN);
		loginButton.addActionListener(this);
		loginButton.setBounds(315, 36, 93, 23);
		getContentPane().add(loginButton);

		// 注册
		register = new JButton("注册");
		register.setFont(new Font("宋体", Font.PLAIN, 12));
		register.setActionCommand(ButtonCommand.REGISTER);
		register.addActionListener(this);
		register.setBounds(315, 67, 93, 23);
		getContentPane().add(register);

		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(139, 264, 106, 60);
		scrollBar.setSize(200, 60);
		getContentPane().add(scrollBar);

		// 聊天内容框
		chatContext = new JTextArea();
		scrollBar.setViewportView(chatContext);
		chatContext.setLineWrap(true);
		chatContext.setTabSize(7);

		// 切换场景部分
		JLabel lblIp2 = new JLabel("场景id");
		lblIp2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblIp2.setBounds(176, 40, 54, 15);
		getContentPane().add(lblIp2);

		// 进入场景
		enterScene = new JButton("跳转场景");
		enterScene.setFont(new Font("宋体", Font.PLAIN, 12));
		enterScene.setActionCommand(ButtonCommand.JUMP);
		enterScene.addActionListener(this);
		enterScene.setBounds(315, 132, 93, 23);
		getContentPane().add(enterScene);

		// 显示场景
		JLabel lblIp3 = new JLabel("场景id");
		lblIp2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblIp2.setBounds(176, 40, 54, 15);
		getContentPane().add(lblIp3);

		sceneId = new JTextField();
		sceneId.setBounds(139, 131, 154, 21);
		getContentPane().add(sceneId);
		sceneId.setColumns(10);

		// 显示场景
		showScene = new JButton("显示场景");
		showScene.setFont(new Font("宋体", Font.PLAIN, 12));
		showScene.setActionCommand(ButtonCommand.SHOW);
		showScene.addActionListener(this);
		showScene.setBounds(315, 165, 93, 23);
		getContentPane().add(showScene);

		// 发送部分
		JLabel label_7 = new JLabel("消息");
		label_7.setFont(new Font("宋体", Font.PLAIN, 12));
		label_7.setBounds(76, 411, 54, 15);
		getContentPane().add(label_7);

		message = new JTextField();
		message.setBounds(139, 408, 222, 21);
		getContentPane().add(message);
		message.setColumns(10);

		JLabel lblid = new JLabel("角色");
		lblid.setFont(new Font("宋体", Font.PLAIN, 12));
		lblid.setBounds(76, 436, 43, 24);
		getContentPane().add(lblid);

		targetPlayer = new JTextField();
		targetPlayer.setBounds(139, 438, 222, 21);
		getContentPane().add(targetPlayer);
		targetPlayer.setColumns(10);

		sendButton = new JButton("发送");
		sendButton.setFont(new Font("宋体", Font.PLAIN, 12));
		sendButton.setBounds(382, 407, 67, 23);
		sendButton.setActionCommand(ButtonCommand.SEND);
		sendButton.addActionListener(this);
		getContentPane().add(sendButton);

		// 错误提示区域
		tips = new JLabel();
		tips.setForeground(Color.red);
		tips.setFont(new Font("宋体", Font.PLAIN, 14));
		tips.setBounds(76, 488, 200, 15);
		getContentPane().add(tips);

		sceneIdContext = new JTextArea();
		sceneIdContext.setBounds(139, 165, 154, 23);
		getContentPane().add(sceneIdContext);
		sceneIdContext.setLineWrap(true);
		sceneIdContext.setTabSize(7);

		int weigh = 500;
		int heigh = 600;
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - weigh) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - heigh) / 2;
		this.setLocation(w, h);
		this.setTitle("MMORPG");
		this.setSize(weigh, heigh);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		switch (event.getActionCommand()) {
		// 登录
		case ButtonCommand.LOGIN:
			try {
				LoginRequest loginRequest = new LoginRequest();
				loginRequest.setPlayerName(playerName.getText());
				loginRequest.setPassward(passward.getText());

				// 构建请求
				Request request = Request.valueOf(ModuleId.PLAYER, PlayerCmd.LOGIN, loginRequest.getBytes());
				client.sendRequest(request);
			} catch (Exception e) {
				tips.setText("无法连接服务器");
			}
			break;
		// 注册
		case ButtonCommand.REGISTER:
			try {
				RegisterRequest registerRequest = new RegisterRequest();
				registerRequest.setPlayerName(playerName.getText());
				registerRequest.setPassward(passward.getText());

				// 构建请求
				Request request = Request.valueOf(ModuleId.PLAYER, PlayerCmd.REGISTER_AND_LOGIN,
						registerRequest.getBytes());
				client.sendRequest(request);
			} catch (Exception e) {
				tips.setText("无法连接服务器");
			}
			break;
		// 发送消息
		case ButtonCommand.SEND:
			try {
				// 判断是广播还是私聊
				if (StringUtils.isEmpty(targetPlayer.getText()) && !StringUtils.isEmpty(message.getText())) {
					PublicChatRequest publicChatRequest = new PublicChatRequest();
					publicChatRequest.setContext(message.getText());

					// 构建请求
					Request request = Request.valueOf(ModuleId.CHAT, ChatCmd.PUBLIC_CHAT, publicChatRequest.getBytes());
					client.sendRequest(request);
				} else {
					if (StringUtils.isEmpty(message.getText())) {
						tips.setText("发送内容不能为空");
						return;
					}

					long playerId = 0;
					try {
						playerId = Long.parseLong(targetPlayer.getText());
					} catch (NumberFormatException e) {
						tips.setText("玩家id必须为数字");
						return;
					}
					PrivateChatRequest privateChatRequest = new PrivateChatRequest();
					privateChatRequest.setContext(message.getText());
					privateChatRequest.setTargetPlayerId(playerId);

					// 构建请求
					Request request = Request.valueOf(ModuleId.CHAT, ChatCmd.PRIVATE_CHAT,
							privateChatRequest.getBytes());
					client.sendRequest(request);
				}
			} catch (Exception e) {
				tips.setText("无法连接服务器");
			}
			break;

		case ButtonCommand.JUMP:
			try {
				short sceneId1 = 0;
				sceneId1 = Short.parseShort(sceneId.getText());
				EnterSceneRequest enterSceneRequest = new EnterSceneRequest();
				enterSceneRequest.setSceneId(sceneId1);
				// 构建请求
				Request request = Request.valueOf(ModuleId.SCENE, SceneCmd.ENTER, enterSceneRequest.getBytes());
				client.sendRequest(request);
			} catch (Exception e) {
				tips.setText("无法连接服务器");
			}
			break;
		case ButtonCommand.SHOW:
			try {
//				short playerId = 0;
//				try {
//					playerId = Short.parseShort(sceneIdContext.getText());
//				} catch (NumberFormatException e) {
//					tips.setText("玩家id必须为数字");
//					return;
//				}
				ShowSceneRequest showSceneRequest = new ShowSceneRequest();
//				showSceneRequest.setSceneId(playerId);
				// 构建请求
				Request request = Request.valueOf(ModuleId.SCENE, SceneCmd.CURSCENE, showSceneRequest.getBytes());
				client.sendRequest(request);
			} catch (Exception e) {
				tips.setText("玩家不存在");
			}
		default:
			break;
		}
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			client.shutdown();
		}
		super.processWindowEvent(e);
	}

	public JTextArea getChatContext() {
		return chatContext;
	}

	public JLabel getTips() {
		return tips;
	}

	public void setPlayerResponse(PlayerResponse playerResponse) {
		this.playerResponse = playerResponse;
	}

	public PlayerResponse getPlayerResponse() {
		return playerResponse;
	}

	public JTextArea getSceneIdContext() {
		return sceneIdContext;
	}

}
