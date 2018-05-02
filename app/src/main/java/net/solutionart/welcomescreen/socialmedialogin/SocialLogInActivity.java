package net.solutionart.welcomescreen.socialmedialogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import net.solutionart.welcomescreen.R;

import org.json.JSONException;
import org.json.JSONObject;

public class SocialLogInActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    CardView Card_Facebook;
    CardView Card_Google;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN;
    GoogleApiClient googleApiClient;
    int REQ_CODE = 9001;
    TextView textView_name;

    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    LoginButton loginButtonFacebook;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_log_in);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);

        // MyCode
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();

        //facebook Log In
        //FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();



    }

    @Override
    protected void onStart() {
        super.onStart();

        Card_Facebook = (CardView)findViewById(R.id.CardViewFacebook);
        Card_Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebookSignIn();
            }
        });

        SignInButton signInButton = (SignInButton) findViewById(R.id.ButtonLouOut);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        Card_Google = (CardView) findViewById(R.id.CardGoogle);
        Card_Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googlesignIn();
            }
        });



        loginButtonFacebook = (LoginButton) findViewById(R.id.login_button);
        //loginButtonFacebook.setReadPermissions(Arrays.asList(EMAIL));
        loginButtonFacebook.setReadPermissions("email" , "public_profile");


        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButtonFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                String name = loginResult.getAccessToken().getUserId();
                textView_name = (TextView)findViewById(R.id.text_name);
                textView_name.setText("Access Token(Facebook) : "+ name);
                Toast.makeText(SocialLogInActivity.this, "Access Token(Facebook) : "+ name, Toast.LENGTH_SHORT).show();

                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        displayUserInfo(object);
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putString("fields" , "first_name , last_name , email , id");
                graphRequest.setParameters(bundle);
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {
                Toast.makeText(SocialLogInActivity.this , "ONcancel()" , Toast.LENGTH_LONG).show();
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(SocialLogInActivity.this , "onError()" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void displayUserInfo(JSONObject object) {
        String first_name , last_name, email ,id;
        first_name = "";
        last_name = "";
        id = "";

        try {
            first_name = object.getString("first_name");
            last_name = object.getString("last_name");
            id = object.getString("id");
            textView_name = (TextView)findViewById(R.id.text_name);
            textView_name.setText("Name(Google) : "+ first_name + "\nlast_name : "+ last_name+ "\nPerson ID : " + id);
            Toast.makeText(this, "Name : " + first_name + "last_name : " + last_name + "\nPerson ID : " + id, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private void googlesignIn() {
        //google
        /*
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent , RC_SIGN_IN);
        */
        //mycode
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent , REQ_CODE);
    }

    private void updateUI(GoogleSignInAccount account) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }

    private void handleResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            String image_url = account.getAccount().toString();
            String personId = account.getId();

            textView_name = (TextView)findViewById(R.id.text_name);
            textView_name.setText("Name(Google) : "+ name + "\nEmail : "+ email+ "\nPerson ID : " + personId);
            Toast.makeText(this, "Name : " + name + "Email : " + email + "\nPerson ID : " + personId, Toast.LENGTH_SHORT).show();
            updateUIMY(true);
        }
        else{
            textView_name = (TextView)findViewById(R.id.text_name);
            textView_name.setText("Sign Out");
            updateUIMY(false);
        }
    }

    private void updateUIMY(boolean isLogin) {
        if(isLogin){
            //Prof_Section.
            Toast.makeText(this , "Success" , Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this , "UnSuccess" , Toast.LENGTH_LONG).show();
        }
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUIMY(false);
            }
        });
    }

    private void facebookSignIn() {

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
