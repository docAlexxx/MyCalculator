package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseActivity implements Constants{

    public int currentCodeStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        MaterialButton backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(v -> {
            Intent themeSettings = new Intent();
            themeSettings.putExtra(CURRENT_THEME, currentCodeStyle);
            setResult(RESULT_OK,themeSettings);
            finish();
        });

        initThemeChooser();
    }



    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonLightTheme), LightThemeCode);
        initRadioButton(findViewById(R.id.radioButtonDarkTheme), DarkThemeCode);
        initRadioButton(findViewById(R.id.radioButtonMonoTheme), MonoThemeCode);
        initRadioButton(findViewById(R.id.radioButtonMainTheme), MainThemeCode);

        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(MainThemeCode))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                currentCodeStyle=codeStyle;
                recreate();
            }
        });
    }
}