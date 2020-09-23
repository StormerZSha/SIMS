package domain;

import utils.StringDateTransformUtils;

import java.util.Date;
/*
教师实体类
 */
public class Teacher {
    private int id;                 //主键id
    private String name;            //教师姓名
    private int tno;                //教师编号
    private int academic;           //教师学历 0本科 1硕士
    private Date birthday;          //出生日期
    private int sex;                //性别 0女 1男
    private String description;     //描述
    private String sexStr;
    private String academicStr;
    private String birthdayStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int getAcademic() {
        return academic;
    }

    public void setAcademic(int academic) {
        this.academic = academic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSexStr() {
        if (sex==0){
            sexStr="女";
        }else {
            sexStr="男";
        }
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getAcademicStr() {
        if (academic==0){
            academicStr="本科";
        }else if (academic==1){
            academicStr="硕士";
        }else if (academic==2){
            academicStr="博士";
        }
        return academicStr;
    }

    public void setAcademicStr(String academicStr) {
        this.academicStr = academicStr;
    }

    public String getBirthdayStr() {
        if (birthday!=null){
            StringDateTransformUtils utils=new StringDateTransformUtils();
            birthdayStr = utils.DateToString(birthday);
        }
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public Teacher(int id, String name, int tno, int academic, Date birthday, int sex, String description, String sexStr, String academicStr) {
        this.id = id;
        this.name = name;
        this.tno = tno;
        this.academic = academic;
        this.birthday = birthday;
        this.sex = sex;
        this.description = description;
        this.sexStr = sexStr;
        this.academicStr = academicStr;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tno=" + tno +
                ", academic=" + academic +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", description='" + description + '\'' +
                ", sexStr='" + sexStr + '\'' +
                ", academicStr='" + academicStr + '\'' +
                '}';
    }
}
