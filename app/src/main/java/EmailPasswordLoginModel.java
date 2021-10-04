import com.google.firebase.auth.FirebaseUser;

public class EmailPasswordLoginModel {
    private String toastMessage;
    private String errorMessage;
    private FirebaseUser user;
    private String emailAddress;
    private String passWord;

    public EmailPasswordLoginModel(){}
    public EmailPasswordLoginModel(String email, String password) {
        emailAddress = email;
        passWord = password;
    }

    public void setToastMessage(String message){
        toastMessage = message;
    }
    public String getToastMessage(){
        return toastMessage;
    }

    public void setErrorMessage(String message){
        errorMessage = message;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setUser(FirebaseUser fbUser){
        user = fbUser;
    }
    public FirebaseUser getUser(){
        return user;
    }

    public void setEmailAddress(String email){
        emailAddress = email;
    }
    public String getEmailAddress(){
        return emailAddress;
    }

    public void setPassWord(String password){
        passWord = password;
    }
    public String getPassWord(){
        return passWord;
    }
}