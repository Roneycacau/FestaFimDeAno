package com.roneycacau.festafimdeano.view;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.roneycacau.festafimdeano.R;

public class MainActivityViewHolder {
    TextView txt_today;
    TextView txt_daysLeft;
    Button btn_confirm;

    public MainActivityViewHolder(AppCompatActivity view) {
        this.txt_today = view.findViewById(R.id.txt_today);
        this.txt_daysLeft = view.findViewById(R.id.txt_daysLeft);
        this.btn_confirm = view.findViewById(R.id.btn_confirm);
    }

    public TextView getTxt_today() {
        return txt_today;
    }

    public void setTxt_today(TextView txt_today) {
        this.txt_today = txt_today;
    }

    public TextView getTxt_daysLeft() {
        return txt_daysLeft;
    }

    public void setTxt_daysLeft(TextView txt_daysLeft) {
        this.txt_daysLeft = txt_daysLeft;
    }

    public Button getBtn_confirm() {
        return btn_confirm;
    }

    public void setBtn_confirm(Button btn_confirm) {
        this.btn_confirm = btn_confirm;
    }
}
