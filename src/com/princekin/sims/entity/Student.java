package com.princekin.sims.entity;

import java.util.Date;

import static java.lang.String.valueOf;

public class Student {

    private  String name;
    private String sex;
    private String people;
    private String political;
    private int id;
    private String verify;
    private String home;
    private Date birthday;
    private String school;
    private String speciality;
    private String grade;
    private  String class_name;
    private String password;

    private double calculus;
    private double linear_algebra;
    private double probability_theory;
    private double algorithm;
    //全部信息构造函数

    public Student(String name, String sex, String people, String political, int id, String verify, String home, Date birthday, String school, String speciality, String grade, String class_name, String password, double calculus, double linear_algebra, double probability_theory, double algorithm) {
        this.name = name;
        this.sex = sex;
        this.people = people;
        this.political = political;
        this.id = id;
        this.verify = verify;
        this.home = home;
        this.birthday = birthday;
        this.school = school;
        this.speciality = speciality;
        this.grade = grade;
        this.class_name = class_name;
        this.password = password;
        this.calculus = calculus;
        this.linear_algebra = linear_algebra;
        this.probability_theory = probability_theory;
        this.algorithm = algorithm;
    }

    //基本信息构造函数
    public Student(String name, String sex, String people, String political, int id, String verify, String home, Date birthday, String school, String speciality, String grade, String class_name, String password) {
        this.name = name;
        this.sex = sex;
        this.people = people;
        this.political = political;
        this.id = id;
        this.verify = verify;
        this.home = home;
        this.birthday = birthday;
        this.school = school;
        this.speciality = speciality;
        this.grade = grade;
        this.class_name = class_name;
        this.password = password;
    }
//成绩构造函数
    public Student(String name, double calculus, double linear_algebra, double probability_theory, double algorithm) {
        this.name = name;
        this.calculus = calculus;
        this.linear_algebra = linear_algebra;
        this.probability_theory = probability_theory;
        this.algorithm = algorithm;
    }
    //密码构造函数
    public Student(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getPeople() {
        return people;
    }

    public String getPolitical() {
        return political;
    }

    public int getId() {
        return id;
    }

    public String getVerify() {
        return verify;
    }

    public String getHome() {
        return home;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSchool() {
        return school;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getGrade() {
        return grade;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getPassword() {
        return password;
    }

    public double getCalculus() {
        return calculus;
    }

    public double getLinear_algebra() {
        return linear_algebra;
    }

    public double getProbability_theory() {
        return probability_theory;
    }

    public double getAlgorithm() {
        return algorithm;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCalculus(double calculus) {
        this.calculus = calculus;
    }

    public void setLinear_algebra(double linear_algebra) {
        this.linear_algebra = linear_algebra;
    }

    public void setProbability_theory(double probability_theory) {
        this.probability_theory = probability_theory;
    }

    public void setAlgorithm(double algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String toString() {
        String str="";
        str=str+id+" "+this.name+" "+this.class_name+" "+valueOf(this.birthday);
        return str;
    }
}
