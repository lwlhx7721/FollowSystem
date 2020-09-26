package com.jxd.model;

/**
 * @author ShiWenZhe
 * @description 学生表
 * @date 2020-09-21 11:17
 */
public class Student {
    /**
     * 学生id
     */
    private int stuId;
    /**
     *学生姓名
     */
    private String stuName;
    /**
     *性别
     * 0为男生，1为女生
     */
    private int sex;
    /**
     *民族
     */
    private String nation;
    /**
     *学生生日
     */
    private String birthday;
    /**
     *籍贯
     */
    private String birthPlace;
    /**
     *学生婚否，0表示未婚，1表示已婚
     */
    private int marry;
    /**
     *联系电话
     */
    private int telephone;
    /**
     *身份证号
     */
    private int idCard;
    /**
     *毕业院校
     */
    private String university;
    /**
     *学生专业
     */
    private String major;
    /**
     *照片
     */
    private String photo;
    /**
     *备注
     */
    private String note;
    /**
     *目前状态，培训/在职
     */
    private String state;
    /**
     *班级id
     */
    private int classId;
    /**
     *部门id
     */
    private int deptId;

    public Student() {
    }

    public Student(int stuId, String stuName, int sex, String nation, String birthday, String birthPlace, int marry, int telephone, int idCard, String university, String major, String photo, String note, String state, int classId, int deptId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.marry = marry;
        this.telephone = telephone;
        this.idCard = idCard;
        this.university = university;
        this.major = major;
        this.photo = photo;
        this.note = note;
        this.state = state;
        this.classId = classId;
        this.deptId = deptId;
    }

    public Student(String stuName, int sex, String nation, String birthday, String birthPlace, int marry, int telephone, int idCard, String university, String major, String photo, String note, String state, int classId, int deptId) {
        this.stuName = stuName;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.marry = marry;
        this.telephone = telephone;
        this.idCard = idCard;
        this.university = university;
        this.major = major;
        this.photo = photo;
        this.note = note;
        this.state = state;
        this.classId = classId;
        this.deptId = deptId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public int getMarry() {
        return marry;
    }

    public void setMarry(int marry) {
        this.marry = marry;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
