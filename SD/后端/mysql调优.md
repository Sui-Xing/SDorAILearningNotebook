<!--ts-->
<!--te-->

# 1、 性能监控

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418115047.png)

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418115248.png)

5.x版本以及之前版本：

查询时间以及消耗的系统资源：

set profiling=1;
show profiles;
show profile;
show profile query 2; #查询query id为2的执行时间
