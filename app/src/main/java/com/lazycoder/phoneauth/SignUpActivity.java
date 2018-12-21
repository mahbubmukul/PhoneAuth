package com.lazycoder.phoneauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lazycoder.phoneauth.Fragments.OtpFragment;
import com.lazycoder.phoneauth.Fragments.PhoneFragment;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        swichToLoginFragment();
    }

    private void swichToLoginFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PhoneFragment()).commit();
    }

    private void swichToOtpFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new OtpFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }

    public void switchToMakePaymentFragment(Bundle bundle) {
        if (bundle == null) {
            swichToOtpFragment();
        } else {
            OtpFragment makePaymentFragment = new OtpFragment();
            makePaymentFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, makePaymentFragment).addToBackStack(null).commit();
        }
    }
}
