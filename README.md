# ProductFlavorsDemo
Android Studio 中利用 Gradle 开发多渠道版本配置步骤

### 前言
在 Android 开发中，我们的一个项目可能需要针对不同的上架市场或者对多个客户进行定制，比如 logo 的修改，欢迎页图片的不同，或者是业务逻辑的不同。</br>
但是不管是哪个版本，通用的代码是占多数的，用多个 Project + svn 进行管理可以实现，但是有些难管理。
其实在 Android Studio 中，通过 Gradle 配置不同的 productFlovers 可以轻松解决这个难题。

### 需求
在一个 Project 中实现对多渠道多版本的同一 App 进行管理，并可以配置差异项。

###解决方法
* #### 新建一个 Project ，在 moudle 的 build.gralde 文件中添加 productFlavors
![添加productFlavors.png](http://upload-images.jianshu.io/upload_images/1981083-01e3aceb9ae0470b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

其中  ```applicationIdSuffix```  是包名后缀，会在打包时将 ```applicationId``` 定义好的包名后面加上  ```applicationIdSuffix``` 定义的内容，如本来包名为 ```com.asura.productflavorsdemo```，加上后缀 ```.debug``` 后就变为 ```com.asura.productflavorsdemo.debug``` 。</br>
这么做是为了在测试阶段可以在一部手机上同时安装所有渠道包的 app，在正式发布时，为了防止客户从不同渠道下载安装出现多个，建议包名不要随意加后缀，应注释掉。</br>
添加完成之后，我们可以重新编译一下项目，发现在 Android Studio 主界面左下角（具体位置跟你的设置有关）的 ```Build Variants``` 窗口中多了一些 variant ，正好就是对应我们之前定义的 productFlavors 。
![Build Variants.png](http://upload-images.jianshu.io/upload_images/1981083-e731ae6b06e21f67.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* #### 在 moulde 中的 ```src``` 文件夹下新建与 ```productFlavors``` 中定义的不同渠道名称一致的文件夹

![创建productFlavors对应的文件夹.png](http://upload-images.jianshu.io/upload_images/1981083-e80526b8c0a9e6c7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```_debug``` 和 ```_AAA``` 中的 ```JumpActivity``` 代码不同，所以从 ```main``` 中抽离出来(在
 ```main``` 中相同包中不能出现 ```JumpActivity```，否则报错)。```MainActivity``` 是不同版本之间一样的，所以仍然放在```main```中。</br>
```java``` 文件夹中的文件，在其他版本和 ```main``` 中不能同时存在，否则会报错。而 ```res``` 文件夹中的文件可以同时存在，其他版本会覆盖 ```mian``` 中的文件。
我们还可以针对不同的版本配置 ```AndroidManifest.xml``` 清单文件，它会与 ```main``` 清单文件中定义的内容合并。</br>
了解了这些，我们对不同版本的配置就很简单了。比如不同版本的 app 图标不同，只需要在不同版本的 ```res\mipmap-xxx``` 文件夹中放入相同的名称的不同图片即可。如果需要不同版本的 app 名称不同，只需要在不同版本的 ```res\value``` 文件夹中的 ```strings.xml``` 中放入相同的名称的不同 value 即可。

### 示例Demo源码下载
[ProductFlavorsDemo](https://github.com/qq709238339/ProductFlavorsDemo)</br>
在这个 demo 中，分别有四个不同的版本代码需要管理，可以 clone 下来自己操作一遍。

![选择不同的 varaint 来编译所需代码.png](http://upload-images.jianshu.io/upload_images/1981083-9ca55c9cd7531afc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

