package com.cn.client.module.scene.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.client.swing.ResultCodeTip;
import com.cn.client.swing.Swingclient;
import com.cn.common.core.model.ResultCode;
import com.cn.common.module.scene.request.ShowSceneRequest;
import com.cn.common.module.scene.response.EnterSceneResponse;
import com.cn.common.module.scene.response.SceneResponse;

@Component
public class SceneHandlerImpl implements SceneHandler {

	@Autowired
	private Swingclient swingclient;

	@Autowired
	private ResultCodeTip resultCodeTip;

	@Override
	public void showCurScene(int resultCode, byte[] data) {
		SceneResponse showSceneResponse = new SceneResponse();
		showSceneResponse.readFromBytes(data);
		StringBuilder builder = new StringBuilder();
		builder.append(showSceneResponse.getSceneId());
		swingclient.getSceneIdContext().append(builder.toString());
	}

	@Override
	public void changeScene(int resultCode, byte[] data) {
		if (resultCode == ResultCode.SUCCESS) {
			EnterSceneResponse enterSceneResponse = new EnterSceneResponse();
			enterSceneResponse.readFromBytes(data);
			swingclient.getTips().setText("改变成功");
		} else {
			swingclient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}
}
