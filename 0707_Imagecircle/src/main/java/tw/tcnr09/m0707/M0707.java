package tw.tcnr09.m0707;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class M0707 extends AppCompatActivity implements View.OnClickListener {

      private CircleImgView img01;
      private CircleImgbutton imgb01;
      private TextView ans;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0707);
            setupViewComponent();
      }

      private void setupViewComponent() {
            img01 = (CircleImgView) findViewById(R.id.m0707_imgview);
            imgb01 = (CircleImgbutton) findViewById(R.id.m0707_imgbutton);
            ans = (TextView) findViewById(R.id.m0707_t001);

            img01.setOnClickListener(this);
            imgb01.setOnClickListener(this);
      }

      @Override
      public void onClick(View v) {
            switch (v.getId()) {
                  case R.id.m0707_imgview:
                        ans.setText(getResources().getString(R.string.m0707_t001)+getString(R.string.m0707_t002));
                        break;
                  case R.id.m0707_imgbutton:

                        ans.setText(getResources().getString(R.string.m0707_t001)+getString(R.string.m0707_t003));
                        break;
            }
      }
}