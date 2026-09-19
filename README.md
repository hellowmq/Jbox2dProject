# Jbox2dProject

> **Fork notice:** This is a historical fork of [kakaandfigo/Jbox2dProject](https://github.com/kakaandfigo/Jbox2dProject), not an independently maintained JBox2D library.

## Changes in this fork

Two code-change commits from 2021 adapt the upstream Android demo:

- update the Android build configuration from SDK 25 to SDK 29;
- replace the original sample icons with five medal images and create 25 simulated views;
- change the dynamic bodies from circles to triangular polygons; and
- tune gravity, density, friction, restitution, damping, and sensor-response behavior.

The project still uses Android Gradle Plugin 3.6.3, JCenter, pre-AndroidX support libraries, and a bundled JBox2D JAR. Its Gradle wrapper metadata is incomplete, and a build with current Android tooling has not been verified.

No repository-level license is provided, and the provenance or reuse terms of the added medal images are not documented. Public visibility does not grant permission to reuse the code or assets.

## Upstream project notes

## 思路
1. 创建一个JboxImpl类，专门用于管理刚体和世界的创建和逻辑计算
2. 自定义一个view，这里为了方便直接继承FrameLayout，并且在真实屏幕中将JboxImpl中计算出刚体运动的坐标绑定给真实的view（也就是这里的image），根据重力感应不停的回调绘制。
3. MainActivity中做重力感应的注册，回调的变化传递到jboxView进行界面重绘。

来一张图片看看
![image](http://upload-images.jianshu.io/upload_images/6193595-d405ce38056b5e40.gif?imageMogr2/auto-orient/strip)
