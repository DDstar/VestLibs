#### 使用说明
* 项目的build.gradle文件里面添加配置
```
   allprojects {
       repositories {
           maven{ url 'https://raw.githubusercontent.com/DDstar/VestLibs/master'}
       }
   }
   ```
* 添加极光配置和id配置
   在 android 的defatltConfig添加以下配置
```
      manifestPlaceholders = [
                JPUSH_PKGNAME: applicationId,
                JPUSH_APPKEY : "3203ac8db7a18e861cab48bc", //JPush上注册的包名对应的appkey.
                JPUSH_CHANNEL: "developer-default", //暂时填写默认值即可.
                vest_id      : "777777"
        ]
```
   * app的module添加依赖
   ```
    implementation 'com.ddstar:vestlibs:1.0.8'
   ```

* 在application的onCreat方法调用
```
 public static void init(Application application, Class mainClass, int splashRes, String appId, String applicationId)
```

* 去掉应用的启动页配置
库里面已经配置了启动页
***
* 4.1.2 mjxxx
* 2.10.8 mjxxx 马甲别人
* 5.0.1 mjqq同事介绍
完美运行
