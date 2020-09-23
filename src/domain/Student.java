package domain;

import utils.StringDateTransformUtils;

import java.util.Date;

/*
学生实体类
 */
public class Student {
    private int id;                 //主键自增长
    private String name;            //学生姓名
    private int sex;                //性别 0女 1男
    private Date birthday;          //出生年月
    private int sno;                //学号
    private int dormitoryid;         //宿舍编号 外键
    private int specialityid;       //专业编号 外键
    private Dormitory dormitory;      //所属宿舍信息
    private Speciality speciality;  //所属专业信息
    private String sexStr;
    private String birthdayStr;

    public int getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(int domitoryid) {
        this.dormitoryid = domitoryid;
    }

    public int getSpecialityid() {
        return specialityid;
    }

    public void setSpecialityid(int specialityid) {
        this.specialityid = specialityid;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", sno=" + sno +
                ", domitoryid=" + dormitoryid +
                ", specialityid=" + specialityid +
                ", dormitory=" + dormitory +
                ", speciality=" + speciality +
                ", sexStr='" + sexStr + '\'' +
                ", birthdayStr='" + birthdayStr + '\'' +
                '}';
    }
}
