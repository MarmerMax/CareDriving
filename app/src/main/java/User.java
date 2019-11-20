import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class User {

    private String firstName;
    private String secondName;
    private String email;
    private String city;
    private int age;


    public abstract void registration();
    public abstract void login();

    public abstract void setLesson(Date date, String time, double duration);
    public abstract void removeLesson(String id);

    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setSecondName(String secondName){this.secondName = secondName;}
    public void setEmail(String email){this.email = email;}
    public void setCity(String city){this.city = city;}
    public void setAge(int age){this.age = age;}


}
