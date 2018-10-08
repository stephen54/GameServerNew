package com.cn.client.module.scene.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.client.swing.ResultCodeTip;
import com.cn.client.swing.Swingclient;
import com.cn.common.core.model.ResultCode;
import com.cn.common.module.scene.request.ShowSceneRequest;

@Component
public class SceneHandlerImpl implements SceneHandler {
	
	@Autowired
	private Swingclient swingclient;
	
	@Autowired
	private ResultCodeTip resultCodeTip;

	@Override
	public void showCurScene(int resultCode, byte[] data) {
		ShowSceneRequest showSceneRequest=new ShowSceneRequest();
		showSceneRequest.readFromBytes(data);
		
		
		StringBuilder builder=new StringBuilder();
		builder.append(showSceneRequest.getSceneId());
		
		
		swingclient.getSceneIdContext().append(builder.toString());
	}

	@Override
	public void changeScene(int resultCode, byte[] data) {
		if(resultCode==ResultCode.SUCCESS) {
			if(resultCode==ResultCode.SUCCESS) {
				swingclient.getTips().setText("改变成功");
			}else {
				swingclient.getTips().setText(resultCodeTip.getTipContent(resultCode));
			}
		}

	}

}
