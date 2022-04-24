package com.example.macroeconomicfoodsecurity.ui.Welcome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WelcomeViewModel extends ViewModel {

        private final MutableLiveData<String> mText;

    public WelcomeViewModel() {
            mText = new MutableLiveData<>();
        }

        public LiveData<String> getText() {
            return mText;
        }
}



