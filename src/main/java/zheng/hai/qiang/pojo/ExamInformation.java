package zheng.hai.qiang.pojo;

public class ExamInformation {
    private int id;//编号
    private String name;//题目
    private String createDate;//创建时间
    private String exam;//包含试卷
    private String totalScore;//总分
    private String examCode;//考试码
    private String person;//创建人
    private String subject;//所属科目examDate
    private String examDate;//考试时长

    public ExamInformation() {
    }

    public ExamInformation(String name, String createDate, String exam, String totalScore, String examCode, String person, String subject, String examDate) {
        this.name = name;
        this.createDate = createDate;
        this.exam = exam;
        this.totalScore = totalScore;
        this.examCode = examCode;
        this.person = person;
        this.subject = subject;
        this.examDate = examDate;
    }

    public ExamInformation(int id, String name, String createDate, String exam, String totalScore, String examCode, String person, String subject, String examDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.exam = exam;
        this.totalScore = totalScore;
        this.examCode = examCode;
        this.person = person;
        this.subject = subject;
        this.examDate = examDate;
    }

    public ExamInformation(int id, String name, String subject, String examDate) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.examDate = examDate;
    }

    public ExamInformation(String examCode) {
        this.examCode = examCode;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    @Override
    public String toString() {
        return "ExamInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                ", exam='" + exam + '\'' +
                ", totalScore='" + totalScore + '\'' +
                ", examCode='" + examCode + '\'' +
                ", person='" + person + '\'' +
                ", subject='" + subject + '\'' +
                ", examDate='" + examDate + '\'' +
                '}';
    }
}
