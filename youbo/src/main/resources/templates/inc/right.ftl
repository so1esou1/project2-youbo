<div class="layui-col-md4">

    <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">本周热议</dt>

        <@hots>
            <#list results as post>
                <dd>
                    <a href="/post/${post.id}">${post.title}</a>
                    <span><i class="iconfont icon-pinglun1"></i> ${post.commentCount}</span>
                </dd>
            </#list>
        </@hots>

        <!-- 无数据时 -->
        <!--
        <div class="fly-none">没有相关数据</div>
        -->
    </dl>

    <div class="fly-panel">
        <div class="fly-panel-title">
            广告区域
        </div>

        <div class="fly-panel-main">
            <!--
            <a href="http://layim.layui.com/?from=fly" target="_blank" class="fly-zanzhu" time-limit="2017.09.25-2099.01.01" style="background-color: #5FB878;">LayIM 3.0 - layui 旗舰之作</a>

            -->
            <a style="color: #FD482C;font-weight: bold">测试用账号:123456</a>
            <a style="color: #FD482C;font-weight: bold">密码:123456</a>
        </div>

    </div>

    <div class="fly-panel fly-link">
        <h3 class="fly-panel-title">友情链接</h3>
        <dl class="fly-panel-main">
            <dd><a href="http://www.6sun.top:8080/" target="_blank">友云</a><dd>

            <dd><a href="" class="fly-link">申请友链</a><dd>
        </dl>
    </div>

</div>