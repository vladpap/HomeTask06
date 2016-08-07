package ru.sbt.model;

public class Wocker extends Person {
    private String otdl;            //  otdel
    private Integer codO;           //  code otdel

    public Wocker(String name, Integer ages, String otdl, Integer codO) {
        super(name, ages);
        this.otdl = otdl;
        this.codO = codO;
    }

    public String getOtdl() {
        return otdl;
    }

    public Integer getCodO() {
        return codO;
    }

    public void setOtdl(String otdl) {
        this.otdl = otdl;
    }

    public void setCodO(Integer codO) {
        this.codO = codO;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return super.toString() + ", otdel " + this.otdl + ", code otdel " + this.codO;
    }
}
