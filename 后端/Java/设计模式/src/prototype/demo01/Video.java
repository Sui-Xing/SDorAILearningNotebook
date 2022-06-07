package prototype.demo01;


// 实现原型模式的两个步骤
// 1.继承一个借口（Cloneable）
// 2.重写一个方法（clone（））

import java.util.Date;

// 对视频进行盗版克隆
public class Video implements Cloneable{

    private String videoName;
    private Date creatDateTime;

    public Video() {

    }

    public Video(String videoName, Date creatDateTime) {
        this.videoName = videoName;
        this.creatDateTime = creatDateTime;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setCreatDateTime(Date creatDateTime) {
        this.creatDateTime = creatDateTime;
    }

    public String getVideoName() {
        return videoName;
    }

    public Date getCreatDateTime() {
        return creatDateTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoName='" + videoName + '\'' +
                ", creatDateTime=" + creatDateTime +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
