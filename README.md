# Encrpytion
大二Java课设 二次元加密器

## 界面展示
### 加载界面
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/加载界面.png)
### 登录界面
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/登录界面.png)
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/登录失败.png)
### 注册界面
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/注册成功.png)
### 主界面
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/主界面.png)
### 加密界面
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/加密界面.png)
### 解密界面
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/解密界面.png)
### 背景菜单
![Image error](https://github.com/Hj7e2/Encrpytion/raw/master/演示图片/背景菜单.png)

## 程序说明
课程设计 没有什么难点(命名和封装很不规范)

双击jar直接运行

accdb保存用户数据

## 加密算法
> 参考密码吧神贴(5层密码表白那个) 实现其加密

1. 将字母代入键盘加密 例 'a' -> 'q'
2. 26个字母按九宫格打字加密 例'q'-> 72(第7个键第2个字母)
3. 常用符号不加密 中文直接异或加密
4. 栅栏加密
5. 倒序
