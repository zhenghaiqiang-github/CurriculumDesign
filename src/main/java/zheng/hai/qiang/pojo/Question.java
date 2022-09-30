package zheng.hai.qiang.pojo;

//试题类
public class Question {
    private int id;//编号
    private String question;//题目
    private String answer;//答案
    private String optionA;//密码
    private String optionB;//
    private String optionC;//
    private String optionD;//
    private String subject;//所属科目
    private String person;//出题人
    private String score;
    private String questionType;
    private String book;
    private String chapter;
    private String difficulty;

    public Question(int id, String question, String answer, String optionA, String optionB, String optionC, String optionD, String subject, String person, String score, String questionType, String book, String chapter, String difficulty) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.subject = subject;
        this.person = person;
        this.score = score;
        this.questionType = questionType;
        this.book = book;
        this.chapter = chapter;
        this.difficulty = difficulty;
    }

    public Question() {
    }

    public Question(String question, String answer, String optionA, String optionB, String optionC, String optionD, String subject, String person, String book, String chapter, String difficulty) {
        this.question = question;
        this.answer = answer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.subject = subject;
        this.person = person;
        this.book = book;
        this.chapter = chapter;
        this.difficulty = difficulty;
    }

    public Question(int id, String question, String answer, String optionA, String optionB, String optionC, String optionD, String subject, String book, String chapter) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", subject='" + subject + '\'' +
                ", person='" + person + '\'' +
                ", score='" + score + '\'' +
                ", questionType='" + questionType + '\'' +
                ", book='" + book + '\'' +
                ", chapter='" + chapter + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
