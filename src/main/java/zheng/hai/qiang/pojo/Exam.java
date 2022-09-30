package zheng.hai.qiang.pojo;

public class Exam {
    private int id;//编号
    private String name;//题目
    private String totalScore;//总分
    private String createDate;//创建时间
    private String person;//创建人
    private String subject;//所属科目
    private String book;//所属书籍
    private String chapter;//章节
    private String question;//包含题目
    public Exam() {
    }
    public Exam(int id, String name, String totalScore, String createDate, String person, String subject, String book, String chapter, String question) {
        this.id = id;
        this.name = name;
        this.totalScore = totalScore;
        this.createDate = createDate;
        this.person = person;
        this.subject = subject;
        this.book = book;
        this.chapter = chapter;
        this.question = question;
    }

    public Exam(String name, String totalScore, String createDate, String person, String subject, String book, String chapter, String question) {
        this.name = name;
        this.totalScore = totalScore;
        this.createDate = createDate;
        this.person = person;
        this.subject = subject;
        this.book = book;
        this.chapter = chapter;
        this.question = question;
    }

    public Exam(int id, String name, String subject, String book, String chapter) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.book = book;
        this.chapter = chapter;
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

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalScore='" + totalScore + '\'' +
                ", createDate='" + createDate + '\'' +
                ", person='" + person + '\'' +
                ", subject='" + subject + '\'' +
                ", book='" + book + '\'' +
                ", chapter='" + chapter + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
