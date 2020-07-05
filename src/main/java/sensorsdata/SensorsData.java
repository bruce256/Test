package sensorsdata;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.sensorsdata.analytics.javasdk.exceptions.InvalidArgumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LvSheng
 * @date 2020/3/23
 **/
public class SensorsData {
  public static void main(String[] args) throws InvalidArgumentException, IOException {
    // 使用 ConcurrentLoggingConsumer 初始化 SensorsAnalytics
    final SensorsAnalytics sa =
        new SensorsAnalytics(new SensorsAnalytics.ConcurrentLoggingConsumer("/Users/LvSheng/logs/sensorsdata.log"));

// 用户的 Distinct ID
    String distinctId = "lvsheng";

// 记录用户登录事件
    sa.track(distinctId, true, "UserLogin");

// 使用神策分析记录用户行为数据
// ...
// 前端的匿名 ID,获取匿名 ID 的方式参考上文
    String anonymousId = "9771C579-71F0-4650-8EE8-8999FA717761";

    String registerId = "lvsheng";
// 用户注册/登录时，将用户登录 ID 与匿名 ID 关联
    sa.trackSignUp(registerId, anonymousId);


// 用户浏览商品
    Map<String, Object> properties = new HashMap<String, Object>();

    // '$time' 属性是系统预置属性，表示事件发生的时间，如果不填入该属性，则默认使用系统当前时间
    properties.put("$time", new Date());
    // '$ip' 属性是系统预置属性，如果服务端中能获取用户 IP 地址，并填入该属性，神策分析会自动根据 IP 地址解析用户的省份、城市信息
    properties.put("$ip", "123.123.123.123");
    properties.put("$project", "production");
    // 商品 ID
    properties.put("ProductId", "123456");
    // 商品类别
    properties.put("ProductCatalog", "Laptop Computer");
    // 是否加入收藏夹，Boolean 类型的属性
    properties.put("isAddedToFav", true);

    // 记录用户浏览商品事件
    sa.track(distinctId, true, "ViewProduct", properties);

    pay(sa);

// 程序结束前，停止 Java SDK 所有服务
    sa.shutdown();
  }

  // 用户订单付款
  public static void pay(SensorsAnalytics sa) throws InvalidArgumentException {
    // 订单中的商品 ID 列表
    List<String> productIdList = new ArrayList<String>();
    productIdList.add("123456");
    productIdList.add("234567");
    productIdList.add("345678");

    Map<String, Object> properties = new HashMap<String, Object>();

    properties.put("$ip", "123.123.123.123");
    properties.put("$project", "production");
    // 订单 ID
    properties.put("OrderId", "abcdefg");
    // 商品 ID 列表，List<String> 类型的属性
    properties.put("ProductIdList", productIdList);
    // 订单金额
    properties.put("OrderPaid", 12.10);

    String distinctId = "ABCDEF123456789";
    // 记录用户订单付款事件
    sa.track(distinctId, true, "PaidOrder", properties);
  }
}
