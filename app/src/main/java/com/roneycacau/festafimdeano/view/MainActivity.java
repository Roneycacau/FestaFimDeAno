package com.roneycacau.festafimdeano.view;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.roneycacau.festafimdeano.R;
import com.roneycacau.festafimdeano.constant.FimDeAnoConstants;
import com.roneycacau.festafimdeano.data.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MainActivityViewHolder mViewHolder;
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/YYYY");
    private SecurityPreferences mSecurityPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewHolder = new MainActivityViewHolder(this);
        this.mSecurityPreferences = new SecurityPreferences(this);
        
        Date date = Calendar.getInstance().getTime();
        String dateFormatted = SIMPLE_DATE_FORMAT.format(date);
        mViewHolder.getTxt_today().setText(dateFormatted);

        String daysLeft = String.format("%s %s", String.valueOf(getDaysLeft()), getString(R.string.string_dias));
        mViewHolder.getTxt_daysLeft().setText(daysLeft);
        mViewHolder.getBtn_confirm().setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_confirm){
            String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENSE_KEY);

            Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
            intent.putExtra(FimDeAnoConstants.PRESENSE_KEY, presence);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    private void verifyPresence() {
        String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENSE_KEY);
        if(presence.equals("")){
            this.mViewHolder.getBtn_confirm().setText(getString(R.string.nao_confirmado));
        }else if(presence.equals(FimDeAnoConstants.CONFIRMATION_YES)){
            this.mViewHolder.getBtn_confirm().setText(getString(R.string.sim));
        }else{
            this.mViewHolder.getBtn_confirm().setText(getString(R.string.nao));
        }

    }

    private int getDaysLeft(){
        Calendar calandarToday = Calendar.getInstance();
        int today = calandarToday.get(Calendar.DAY_OF_YEAR);

        Calendar calendarLastDay = Calendar.getInstance();
        int maxDay = calendarLastDay.getMaximum(Calendar.DAY_OF_YEAR);
        return maxDay - today;
    }

}
