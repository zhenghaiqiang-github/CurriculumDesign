package zheng.hai.qiang.pojo;

import javax.persistence.criteria.CriteriaBuilder;

public class Teacher {
    private int                id;//学生编号
    private String             name;//姓名
    private String             account;//账号
    private String             password;//密码
    private String             question;//密保问题
    private String             answer;//密保答案
    private Integer money;

    public Teacher() {
    }

    public Teacher(int id, String name, String account, String password, String question, String answer) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public Teacher(String name, String account, String password, String question, String answer) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.question = question;
        this.answer = answer;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", password='" + password + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
