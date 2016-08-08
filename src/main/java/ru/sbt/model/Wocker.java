package ru.sbt.model;

public class Wocker {
    private String name;
    private Number ages;
    private String otdl;            //  otdel
    private Integer codO;           //  code otdel

    public Wocker(String name, Number ages, String otdl, Integer codO) {
        this.name = name;
        this.ages = ages;
        this.otdl = otdl;
        this.codO = codO;
    }

    public String getName() {
        return name;
    }

    public Number getAges() {
        return ages;
    }

    public String getOtdl() {
        return otdl;
    }

    public Integer getCodO() {
        return codO;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAges(Number ages) {
        this.ages = ages;
    }

    public void setOtdl(String otdl) {
        this.otdl = otdl;
    }

    public void setCodO(Integer codO) {
        this.codO = codO;
    }

    @Override
    public String toString() {
        return this.name + ", age " + this.ages + ", otdel " + this.otdl + ", code otdel " + this.codO;
    }
}
