package com.lsw.jsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String data = "[\n" +
            "    {\n" +
            "        \"_id\": \"59b8875e114f3500070e9fcb\",\n" +
            "        \"when\": 1505265476634,\n" +
            "        \"aId\": \"5943a63c6fe1c80007fbfd4d\",\n" +
            "        \"where\": \"存储\",\n" +
            "        \"subject\": \"mu\",\n" +
            "        \"content\": \"主题11\",\n" +
            "        \"summary\": \"吴\",\n" +
            "        \"assets\": [\n" +
            "            {\n" +
            "                \"url\": \"https://cdn.iartev.cn/i/f6b3e045-d648-416c-b83b-9c6d0aef92f6.jpg\",\n" +
            "                \"type\": \"image\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"author\": {\n" +
            "            \"_id\": \"59ad107931a65a0007ccda3f\",\n" +
            "            \"password\": \"e10adc3949ba59abbe56e057f20f883e\",\n" +
            "            \"name\": \"luo\",\n" +
            "            \"gender\": 1,\n" +
            "            \"aId\": \"5943a63c6fe1c80007fbfd4d\",\n" +
            "            \"sn\": \"12\",\n" +
            "            \"phone\": \"18360538639\",\n" +
            "            \"grade\": 7,\n" +
            "            \"klass\": 3,\n" +
            "            \"c\": 1504514169537,\n" +
            "            \"u\": 1505796581572,\n" +
            "            \"status\": 0,\n" +
            "            \"auth\": {\n" +
            "                \"code\": \"4ef1a4706dc9eb68103c86abeff79094\",\n" +
            "                \"deviceId\": \"0c5af65a991bcac0e0d264316aaf0291\"\n" +
            "            },\n" +
            "            \"authorities\": {\n" +
            "                \"_id\": \"5943a63c6fe1c80007fbfd4d\",\n" +
            "                \"name\": \"厦门市音乐学校\",\n" +
            "                \"type\": 0,\n" +
            "                \"c\": 1497605692273,\n" +
            "                \"u\": 1499676299349,\n" +
            "                \"status\": 0\n" +
            "            }\n" +
            "        },\n" +
            "        \"c\": 1505265502305,\n" +
            "        \"u\": 1505265502305,\n" +
            "        \"status\": 0,\n" +
            "        \"year\": 2017,\n" +
            "        \"moy\": 201709,\n" +
            "        \"foy\": 1,\n" +
            "        \"fom\": 1\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"59b883bad628e20007a6398e\",\n" +
            "        \"when\": 1505404800000,\n" +
            "        \"aId\": \"5943a63c6fe1c80007fbfd4d\",\n" +
            "        \"where\": \"中山陵\",\n" +
            "        \"subject\": \"ar\",\n" +
            "        \"content\": \"主题2\",\n" +
            "        \"summary\": \"222\",\n" +
            "        \"assets\": [\n" +
            "            {\n" +
            "                \"url\": \"https://cdn.iartev.cn/i/f73f7e8a-002f-4699-a2b3-6c7059f8f953.jpg\",\n" +
            "                \"type\": \"image\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"author\": {\n" +
            "            \"_id\": \"59ad107931a65a0007ccda3f\",\n" +
            "            \"password\": \"e10adc3949ba59abbe56e057f20f883e\",\n" +
            "            \"name\": \"luo\",\n" +
            "            \"gender\": 1,\n" +
            "            \"aId\": \"5943a63c6fe1c80007fbfd4d\",\n" +
            "            \"sn\": \"12\",\n" +
            "            \"phone\": \"18360538639\",\n" +
            "            \"grade\": 7,\n" +
            "            \"klass\": 3,\n" +
            "            \"c\": 1504514169537,\n" +
            "            \"u\": 1505796581572,\n" +
            "            \"status\": 0,\n" +
            "            \"auth\": {\n" +
            "                \"code\": \"4ef1a4706dc9eb68103c86abeff79094\",\n" +
            "                \"deviceId\": \"0c5af65a991bcac0e0d264316aaf0291\"\n" +
            "            },\n" +
            "            \"authorities\": {\n" +
            "                \"_id\": \"5943a63c6fe1c80007fbfd4d\",\n" +
            "                \"name\": \"厦门市音乐学校\",\n" +
            "                \"type\": 0,\n" +
            "                \"c\": 1497605692273,\n" +
            "                \"u\": 1499676299349,\n" +
            "                \"status\": 0\n" +
            "            }\n" +
            "        },\n" +
            "        \"c\": 1505264570749,\n" +
            "        \"u\": 1505264570749,\n" +
            "        \"status\": 0,\n" +
            "        \"year\": 2017,\n" +
            "        \"moy\": 201709,\n" +
            "        \"foy\": 1,\n" +
            "        \"fom\": 1\n" +
            "    }\n" +
            "]";
    private List<ActivitiesDisplayItemBean> list = new ArrayList<>();
    private ListView listView;
    private ActivityDisplayAdapter activityDisplayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.fragment_school_lv);
//        parseJsonByGson();
        parseJsonByFastJson();
        activityDisplayAdapter = new ActivityDisplayAdapter(this, list);
        listView.setAdapter(activityDisplayAdapter);

    }

    /**
     * 通过Gson解析数据
     */
    public void parseJsonByGson() {
        Gson gson = new Gson();
        list = gson.fromJson(data, new TypeToken<List<ActivitiesDisplayItemBean>>() {
        }.getType());

    }

    /**
     * 通过FastJson解析数据
     */
    public void parseJsonByFastJson() {
        // 方法1
//        list = JSON.parseObject(data, new TypeReference<List<ActivitiesDisplayItemBean>>() {
//        });
        // 方法2
        list = JSON.parseArray(data, ActivitiesDisplayItemBean.class);
    }
}
