public class Student {

    private String username;
    private String firstname;
    private String lastname;
    private char classOrigin;

    public Student(String username, String firstname, String lastname, char classOrigin){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.classOrigin = classOrigin;
    }

    public Student(String[] info) {
        this.username = info[0];
        this.firstname = info[1];
        this.lastname = info[2];
        if (info.length > 3) {
            this.classOrigin = info[3].charAt(0);
        } else {
            this.classOrigin = '!';
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getClassOrigin() {
        return classOrigin;
    }

    public void setClassOrigin(char classOrigin) {
        this.classOrigin = classOrigin;
    }

    @Override
    public String toString(){
        return " Username = " + username + " Firstname = " + firstname + " Lastname = " + lastname + " classOrigin = " + classOrigin;
    }
}
