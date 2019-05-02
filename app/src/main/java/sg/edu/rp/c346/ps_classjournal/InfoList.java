package sg.edu.rp.c346.ps_classjournal;


import java.io.Serializable;

public class InfoList implements Serializable {
    private String week;
    private String grade;

    public InfoList(String week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
