package com.wjspc.service.impl;

import com.baidu.aip.speech.AipSpeech;
import com.wjspc.service.OrcService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created by 79445 on 2018/6/7.
 */
@Service
public class OrcServiceImpl implements OrcService {

    //设置APPID/AK/SK
    public static final String APP_ID = "11361857";
    public static final String API_KEY = "l4NtQmo1oqGprQF13s1rwy4X";
    public static final String SECRET_KEY = "EI3SOks6GjomqG7Zz4SifCSbMhG3BXI9";


    @Override
    public Object orc() {
        /**
         * 图片文字识别
         */
        // 初始化一个AipOcr
        //AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        /*HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("probability", "true");

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);

        // 调用接口
        String image = "C:\\Users\\79445\\Desktop\\123.jpg";
        JSONObject res = client.basicAccurateGeneral(image, options);*/




        /**
         * 语音识别
         */
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        String path = "C:\\Users\\79445\\Desktop\\16k.pcm";
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);

        return asrRes.toString();
    }
}
