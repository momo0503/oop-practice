package org.example;

public class User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void initPassword(){
        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String randomPassword = randomPasswordGenerator.generatePassword();

        //조건에 맞을때에만 생성해준다.
        if(randomPassword.length() >=8 || randomPassword.length() <=12){
            this.password = password;
        }


    }
}
