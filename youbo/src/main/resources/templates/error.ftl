<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>错误提示</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="shortcut icon" href="/res/images/you.png">
    <link rel="stylesheet" href="/res/layui/css/layui.css">
    <link rel="stylesheet" href="/res/css/global.css">
</head>
<body background="/res/images/back3.jpg">

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="/">
      <img src="/res/images/youbo.png" alt="友博" style="+JU8height: 41px;">
    </a>
    <ul class="layui-nav fly-nav layui-hide-xs">
      <li class="layui-nav-item layui-this">
        <a href="/"><i class="iconfont icon-jiaoliu"></i>返回主页</a>
      </li>
      <li class="layui-nav-item">
        <a target="_blank" href="https://github.com/so1esou1/project2-youbo"><i class=""></i>github网页</a>
      </li>
    </ul>

    <ul class="layui-nav fly-nav-user">

    </ul>
  </div>
</div>

<div class="layui-container fly-marginTop">
    <div class="fly-panel">
        <div class="fly-none">
            <h2><i class="iconfont icon-tishilian"></i></h2>
            <p>${message}</p>
        </div>
    </div>
</div>

</body>
</html>

