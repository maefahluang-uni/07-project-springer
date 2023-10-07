package user.service.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="fname")
    private String firstname;

    @Column(name="lname")
    private String lastname;

    @Column(name="email")
    private String email;

    @Column(name="pnumber")
    private String phone;

    // @Transient
    // private int port;

    @OneToOne(cascade = CascadeType.PERSIST) //add เข้าไปใหม่ //2 entity ส่งข้อมูลไปพร้อมกัน
    @JoinColumn(name="account_id", referencedColumnName="id")
    private Account account;

    public User() {
    }

  
    public User(Long id, String firstname, String lastname, String email, String phone, Account account) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }


    //     public int getPort() {
    //     return port;
    // }
    // public void setPort(int port) {
    //     this.port = port;
    // }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    // Getters and setters
}

