#### 使用说明
* 项目的build.gradle文件里面添加配置
```
   allprojects {
       repositories {
           maven{ url 'https://raw.githubusercontent.com/DDstar/VestLibs/master'}
       }
   }
   ```
* 添加极光配置
再android 的defatltConfig添加以下配置
```
 manifestPlaceholders = [
                JPUSH_PKGNAME: applicationId,
                JPUSH_APPKEY : "3203ac8db7a18e861cab48bc", //JPush上注册的包名对应的appkey.
                JPUSH_CHANNEL: "developer-default", //暂时填写默认值即可.
        ]
```
   * app的module添加依赖
   ```
    implementation 'com.ddstar:vestlibs:1.0.8'
   ```

* 自定义Application并继承DfApp 实现以下方法
```
 @Override
    protected Class setMainActivityClass() {
        //返回壳子的首页
        return MainActivity.class;
    }

    @Override
    protected VestType setVestType() {
        //设置cp类型
        return VestType.VEST_TYPE_1;
    }

    @Override
    protected int setSplashRes() {
        //返回欢迎页的图片资源
        return R.mipmap.ic_launcher;
    }

    @Override
    protected String setAppId() {
        //id
        return "newxk20180719005";
    }

    @Override
    protected String setApplicationIId() {
        //返回应用id
        return BuildConfig.APPLICATION_ID;
    }
```
* 去掉应用的启动页配置
库里面已经配置了启动页
***
* 3.0.0 mjxxx 新新
* 2.10.8 mjxxx 马甲别人
* 2.11.0 mjqq同事介绍
完美运行
