package domain;

import java.util.List;

/**
专业实体类
 */
public class Speciality {
    private int id;             //主键id
    private String name;        //专业名称
    private String faculty;     //所属院系
    private int type;           //培养类型 0普通 1重点
    private String typeStr;
    private List<Student> students;

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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeStr() {
        if (type==0){
            typeStr="普通";
        }else {
            typeStr="重点";
        }
        return typeStr;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public Speciality(int id, String name, String faculty, int type, String typeStr) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.type = type;
        this.typeStr = typeStr;
    }

    public Speciality() {
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", type=" + type +
                ", typeStr='" + typeStr + '\'' +
                '}';
    }
}
