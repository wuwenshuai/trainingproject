package cn.shuhe.common;

import cn.shuhe.domain.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wuwenshuai
 * @Date: 2018/7/24 17:29
 * @Description:
 */
public class Test1 {

    @Test
    public void  test(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","carry");
        jsonObject.put("age",12);
        System.out.println(jsonObject.toJSONString());

        System.out.println("=========================================");
        //将javaBean对象序列化为json
        PageResult result = new PageResult();

        List rows = new ArrayList();
        User user = new User();
        user.setUserId(1L);
        user.setUserName("carry");
        user.setUserPassword("123456");

        User user1 = new User();
        user1.setUserId(2L);
        user1.setUserName("jerry");
        user1.setUserPassword("123456");

        rows.add(user);
        rows.add(user1);
        result.setTotal(2);
        result.setRows(rows);


        JSONObject object = new JSONObject();
        String jsonString = object.toJSONString(result);

        System.out.println(jsonString);

        System.out.println("=========================================");

        //反序列化（把json对象转化为jsonObject或者jsonArray）
        String json = "{\"name\":\"carry\",\"age\":12}";
        JSONObject jsonToObject = new JSONObject();
         jsonToObject = (JSONObject) JSON.parse(json);
        System.out.println(jsonToObject);


        System.out.println("=========================================");
        //把json对象转化为jsonObject或者jsonArray

        String jsons="{\"name\":\"wjk\",\"age\":\"22\",\"love\":[{\"love1\":\"coding\",\"love2\":\"movie\"},{\"love1\":\"money\",\"love2\":\"NBA\"}]}";//定义json文本
        //先将json文本转换为jsonobject
        JSONObject jsonObject1 = JSON.parseObject(jsons);
        System.out.println("test========JSONObject============test");
        System.out.println(jsonObject1);
        System.out.println("test=========String=========test");
        String string = jsonObject1.toJSONString();
        System.out.println(string);

        System.out.println(jsonObject1);

        String love = jsonObject1.getString("love");

        JSONArray array = new JSONArray();

        array  = JSON.parseArray(love);
        System.out.println(array);


    }




}
