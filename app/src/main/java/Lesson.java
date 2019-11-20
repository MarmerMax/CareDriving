import java.util.UUID;

public class Lesson {

    private String date;
    private String time;
    private double duration;
    private final String id;

    private final String studentId;
    private final String teacherId;

    public Lesson(String date,
                  String time,
                  double duration,
                  String studentId,
                  String teacherId)
    {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.id = UUID.randomUUID().toString();
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    public String getDate(){return date;}
    public String getTime(){return time;}
    public double getDuration(){return duration;}
    public void setDate(String date){this.date = date;}
    public void setTime(String time){this.time = time;}
    public void setDuration(double duration){this.duration = duration;}
}
