package com.lazycoder.phoneauth.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lazycoder.phoneauth.R;
import com.lazycoder.phoneauth.SignUpActivity;


public class PhoneFragment extends Fragment {

    EditText phoneTextView;
    Button continueBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        phoneTextView = view.findViewById(R.id.editTextPhone);
        continueBtn = view.findViewById(R.id.buttonContinue);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = phoneTextView.getText().toString().trim();
                if (number.isEmpty() || number.length() < 11) {
                    phoneTextView.setError("Valid number is required");
                    phoneTextView.requestFocus();
                    return;
                }
                String phoneNumber = "+88" + number;

                Bundle bundle = new Bundle();
                bundle.putString("PHONE", phoneNumber);
                ((SignUpActivity) getActivity()).switchToMakePaymentFragment(bundle);
            }
        });


    }


}
