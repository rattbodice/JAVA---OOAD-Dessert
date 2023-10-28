import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class User {
    int userId;
    static String fname;
    static String lname;
    static String username;
    static String password;
    static String email;
    static Date createDate;

    User(String[] dataUser){
        this.userId = Integer.parseInt(dataUser[0]);
        this.fname = dataUser[1];
        this.lname = dataUser[2];
        this.username = dataUser[3];
        this.password = dataUser[4];
        this.email = dataUser[5];
        this.createDate = convertStringToDate(dataUser[6]);
    }

    public static String getName(){
        return fname+" "+lname;
    }

    public static String getUserName(){
        return username;
    }

    public static String getPassword(){
        return password;
    }

    public static String getEmail(){
        return email;
    }

    public static Date getCreateDate(){
        return createDate;
    }

    private static void setName(String name){
        String[] array = name.split(" ");
        fname = array[0];
        lname = array[1];
    }

    private static void setUserName(String username2){
        username = username2;
    }

    private static void setPassword(String password2){
        password = password2;
    }

    private static void setEmail(String mail){
        email =mail;
    }

    private static void setCreateDate(Date date){
        createDate = date;
    }



    // แปลงข้อมูลวันที่ String ให้เป็น Date
    private Date convertStringToDate(String dateUser) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateUser);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }
        return date;
    }
}
