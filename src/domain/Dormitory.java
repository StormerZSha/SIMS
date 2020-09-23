package domain;

import java.util.List;

/*
宿舍实体类
 */
public class Dormitory {
    private int id;         //主键自增长
    private int dno;        //宿舍号
    private int type;       //宿舍类型 0 单人间 1四人间 2六人间 3八人间
    private String typeStr;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeStr() {
        if (type==0){
            typeStr="单人间";
        }else if (type==1){
            typeStr="四人间";
        }else if (type==2){
            typeStr="六人间";
        }else if (type==3){
            typeStr="八人间";
        }
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public Dormitory(int id, int dno, int type, String typeStr) {
        this.id = id;
        this.dno = dno;
        this.type = type;
        this.typeStr = typeStr;
    }

    public Dormitory() {
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "id=" + id +
                ", dno=" + dno +
                ", type=" + type +
                ", typeStr='" + typeStr + '\'' +
                ", students=" + students +
                '}';
    }
}
