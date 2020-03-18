package com.technology.circles.apps.done.activities_fragments.activity_profile;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technology.circles.apps.done.R;
import com.technology.circles.apps.done.databinding.ActivityProfileBinding;
import com.technology.circles.apps.done.interfaces.Listeners;
import com.technology.circles.apps.done.language.LanguageHelper;

import io.paperdb.Paper;

public class ProfileActivity extends AppCompatActivity implements Listeners.BackListener{

        private ActivityProfileBinding binding;
        private String lang;


        @Override
        protected void attachBaseContext(Context newBase) {
            Paper.init(newBase);
            super.attachBaseContext(LanguageHelper.updateResources(newBase, Paper.book().read("lang", "ar")));
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
            initView();
        }

        private void initView() {
            Paper.init(this);
            lang = Paper.book().read("lang","ar");
            binding.setBackListener(this);
            binding.setLang(lang);
        }

        @Override
        public void back() {
            finish();
        }
}
