package com.roneycacau.festafimdeano.view;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.roneycacau.festafimdeano.R;
import com.roneycacau.festafimdeano.constant.FimDeAnoConstants;
import com.roneycacau.festafimdeano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private DetailsActivityViewHolder mViewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.mSecurityPreferences = new SecurityPreferences(this);

        mViewHolder = new DetailsActivityViewHolder(this);
        mViewHolder.getChb_participate().setOnClickListener(this);
        this.loadDataFromActivity();
    }

    private void loadDataFromActivity() {
        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String presence = extra.getString(FimDeAnoConstants.PRESENSE_KEY);
            if(presence != null && presence.equals(FimDeAnoConstants.CONFIRMATION_YES)){
                this.mViewHolder.getChb_participate().setChecked(true);
            }else{
                this.mViewHolder.getChb_participate().setChecked(false);
            }
        }
    }

    private SecurityPreferences mSecurityPreferences;
    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.chb_participate){
            if(this.mViewHolder.getChb_participate().isChecked()){
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENSE_KEY, FimDeAnoConstants.CONFIRMATION_YES );
            }else{
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENSE_KEY, FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }
}
