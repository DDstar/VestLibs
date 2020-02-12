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
        ]
```
   * app的module添加依赖
   ```
      implementation 'com.ddstar:vestlibs:20.02.12'
   ```
* 在application的onCreat方法调用
```
 public static void init(Application application, Class mainClass, int splashRes, String appId, String applicationId)
```
* 需要修改强更页面的图片的话，在application的onCreat方法调用
```
   VestHelper.getInstance().setDownBg(R.drawable.bg_spdate);
```

* 去掉应用的启动页配置
库里面已经配置了启动页

完美
库里面已经配置了启动页运行
