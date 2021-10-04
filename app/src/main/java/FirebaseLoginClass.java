import android.content.ContentValues;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseLoginClass {
    private FirebaseAuth myAuth;

    public FirebaseLoginClass(){
        myAuth = FirebaseAuth.getInstance();
    }

    public void loginWithUserNameAndPassword(EmailPasswordLoginModel eplm, SuccessFailureInterface sfi) {
        myAuth.signInWithEmailAndPassword(eplm.getEmailAddress(), eplm.getPassWord())
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        logError("Sign in with email and password: successful");
                        eplm.setUser(myAuth.getCurrentUser());
                        eplm.setToastMessage("Welcome!!");
                        sfi.OnSuccess(eplm);
                    } else {
                        createLoginWithUserAndPassword(eplm, sfi);
                    }
                });
    }

    public void createLoginWithUserAndPassword(EmailPasswordLoginModel eplm, SuccessFailureInterface sfi) {
        myAuth.createUserWithEmailAndPassword(eplm.getEmailAddress(), eplm.getPassWord())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        eplm.setToastMessage("User created successfully!");
                        eplm.setUser(myAuth.getCurrentUser());
                        logError("createuserWithEmail:Success");
                        sfi.OnSuccess(eplm);
                    } else {
                        eplm.setToastMessage("Login Failed: try again");
                        eplm.setEmailAddress("Either your password is wrong or you are trying to create a new user with an email that already exists in the system.");
                        logError("createUserWithEmail:failure");
                        sfi.OnFailure(eplm);
                    }
                });
    }

    private void logError(String message){
        Log.w(ContentValues.TAG, message);
    }
}
