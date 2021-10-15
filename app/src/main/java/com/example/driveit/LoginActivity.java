package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.driveit.handler.PreferenceHandler;
import com.example.driveit.network.APIClient;
import com.example.driveit.network.APIInterface;
import com.example.driveit.pojo.LoginResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    APIInterface apiInterface;
    private static final int REQUEST_READ_CONTACTS = 0;
    private EditText mEmailView, mPasswordView;
    private View mLoginFormView;
    private Button loginButton, firebaseButton;
    private PreferenceHandler preferenceHandler;
    private Boolean firebaseLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);

        setContentView(R.layout.activity_login);
        hideSystemUI();

        preferenceHandler = new PreferenceHandler(this);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        mAuth = FirebaseAuth.getInstance();

        Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mLoginFormView = findViewById(R.id.login_form_view);
        mEmailView = (EditText) findViewById(R.id.emailEditText);
        mPasswordView = (EditText) findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);
        firebaseButton = findViewById(R.id.firebaseLogin);


        mPasswordView.setOnEditorActionListener((textView, id, keyEvent) -> {
            if (id == R.id.buttonLogin || id == EditorInfo.IME_NULL) {
                attemptLogin();
                return true;
            }
            return false;
        });
        loginButton.setOnClickListener(v -> {
            firebaseLogin = false;
            attemptLogin();
        });
        firebaseButton.setOnClickListener(v -> {
            firebaseLogin = true;
            attemptLogin();
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


    public void userExecLogin(View v) {
        attemptLogin();
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError("Password is invali");
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError("Email is invalid");
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError("Email is invalid");
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            // showProgress(true);
            ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            if ((networkInfo != null && networkInfo.isConnected())) {
                if (firebaseLogin)
                    firebaseLoginUser(email, password);
                else
                    executeSignIn(email, password);

            } else {

                Snackbar.make(mLoginFormView, "Internet connection error", Snackbar.LENGTH_LONG)
                        .setAction("Open settings", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                            }
                        }).setActionTextColor(getResources().getColor(android.R.color.holo_orange_dark)).show();
            }

        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private void executeSignIn(final String mEmail, final String mPassword) {
        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Signin you in", "Wait a sec...", true, true);

        final LoginResponse login = new LoginResponse(mEmail, mPassword);
        Call<LoginResponse> call = apiInterface.createUser(login);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                progressDialog.dismiss();

                LoginResponse loginResponse = response.body();
                Log.e("keshav", "loginResponse 1 --> " + loginResponse);
                Toast.makeText(LoginActivity.this, "Welcome user", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this, Home.class));
                finish();
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Log.e("neutron_login", "message " + t.toString());
                Snackbar.make(mLoginFormView, "Error is " + t.toString(), Snackbar.LENGTH_LONG).setAction("retry", v -> userExecLogin(v)).setActionTextColor(getResources().getColor(android.R.color.holo_red_light)).show();
                call.cancel();
            }
        });


        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setOnCancelListener(dialog -> {
            call.cancel();
            Snackbar.make(mLoginFormView, "Sign in Operation cancelled", Snackbar.LENGTH_LONG).setAction("retry", this::userExecLogin).setActionTextColor(getResources().getColor(android.R.color.holo_blue_light)).show();
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }

    private void reload() {

    }

    private void updateUI(FirebaseUser user) {
        Log.e("error", "error error update ui");
    }

    private void firebaseLoginUser(final String mEmail, final String mPassword) {
        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Signin via firebase", "Wait a sec...", true, true);

        mAuth.signInWithEmailAndPassword(mEmail, mPassword)
                .addOnCompleteListener(this, task -> {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.e("v", "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                        startActivity(new Intent(LoginActivity.this, Home.class));
                        finish();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e("TAG", "signInWithEmail:failure");
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }

                });
    }
}