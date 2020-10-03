public class Assignment3Builder {
    public static void main(String[] args) {
        Professor professor = new Professor.Builder("Emma", "Wang")
                .setPhone("0045-1234556")
                .setAddress("Juventus")
                .setMail("CR@Juventus.org").build();
    }
}

class Professor {
    private String firstName;
    private String lastName;
    private String id;

    //optional parameters
    private int age;
    private int personalId;
    private String phone;
    private String address;
    private String mail;

    public static class Builder {
        //required parameters
        private String firstName;
        private String lastName;

        //optional parameters
        private int age;
        private int personalId;
        private String phone;
        private String address;
        private String mail;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPersonalId(int personalId) {
            this.personalId = personalId;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder setMail(String mail) {
            this.mail = mail;
            return this;
        }
        public Professor build() {
            // call the private constructor in the outer class
            return new Professor(firstName, lastName, age, personalId, phone, address, mail);
        }
    }

    public Professor(String firstName, String lastName, int age, int personalId, String phone, String address, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personalId = personalId;
        this.phone = phone;
        this.address = address;
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public int getPersonalId() {
        return personalId;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getMail() {
        return mail;
    }
}