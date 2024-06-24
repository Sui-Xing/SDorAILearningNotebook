package prototype.demo02;



import java.util.Date;

// 实现深克隆，在重写的clone（）方法中对该类中的属性也进行克隆
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
        // 关键步骤，在此处修改clone()方法
        // 令该方法的属性也克隆一份
        Object obj=super.clone();
        Video v= (Video) obj;
        Video ob= (Video) super.clone();
        Date date = (Date) this.creatDateTime.clone();
        ob.setCreatDateTime(date);
        return ob;
    }
}
