package zheng.hai.qiang.pojo;

public class ExamResult {
    private int id;//编号
    private String studentaccount;//参加考试学生账号
    private String studentName;//参加考试学生姓名
    private String examinforid;//考试信息ID
    private String person;//考试创建人
    private String totalscore;//总分
    private String score;//得分
    private String failquestion;//错题
    private String examCode;//
    private String subject;//
    private String examName;//

    public ExamResult() {
    }

    public ExamResult(int id, String studentaccount, String studentName, String examinforid, String person, String totalscore, String score, String failquestion, String examCode, String subject, String examName) {
        this.id = id;
        this.studentaccount = studentaccount;
        this.studentName = studentName;
        this.examinforid = examinforid;
        this.person = person;
        this.totalscore = totalscore;
        this.score = score;
        this.failquestion = failquestion;
        this.examCode = examCode;
        this.subject = subject;
        this.examName = examName;
    }

    public ExamResult(String studentaccount, String studentName, String examinforid, String person, String totalscore, String score, String failquestion, String examCode, String subject, String examName) {
        this.studentaccount = studentaccount;
        this.studentName = studentName;
        this.examinforid = examinforid;
        this.person = person;
        this.totalscore = totalscore;
        this.score = score;
        this.failquestion = failquestion;
        this.examCode = examCode;
        this.subject = subject;
        this.examName = examName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentaccount() {
        return studentaccount;
    }

    public void setStudentaccount(String studentaccount) {
        this.studentaccount = studentaccount;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getExaminforid() {
        return examinforid;
    }

    public void setExaminforid(String examinforid) {
        this.examinforid = examinforid;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(String totalscore) {
        this.totalscore = totalscore;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFailquestion() {
        return failquestion;
    }

    public void setFailquestion(String failquestion) {
        this.failquestion = failquestion;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "id=" + id +
                ", studentaccount='" + studentaccount + '\'' +
                ", studentName='" + studentName + '\'' +
                ", examinforid='" + examinforid + '\'' +
                ", person='" + person + '\'' +
                ", totalscore='" + totalscore + '\'' +
                ", score='" + score + '\'' +
                ", failquestion='" + failquestion + '\'' +
                ", examCode='" + examCode + '\'' +
                ", subject='" + subject + '\'' +
                ", examName='" + examName + '\'' +
                '}';
    }
}
