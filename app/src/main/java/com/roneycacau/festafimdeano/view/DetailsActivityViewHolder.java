package com.roneycacau.festafimdeano.view;

import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import com.roneycacau.festafimdeano.R;

public class DetailsActivityViewHolder {
    private CheckBox chb_participate;

    public DetailsActivityViewHolder(AppCompatActivity view) {
        this.chb_participate = view.findViewById(R.id.chb_participate);
    }

    public CheckBox getChb_participate() {
        return chb_participate;
    }
}
