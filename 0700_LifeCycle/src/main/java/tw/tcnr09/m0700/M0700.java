package tw.tcnr09.m0700;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class M0700 extends AppCompatActivity {
      private final String TAG = "tcnr09=>";

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0700);
            Log.d(TAG, "onCreate");
            setupViewComponent();
      }

      private void setupViewComponent() {
            //自定義方法
            int a = 9999 + 123;
            Log.d(TAG, "setupViewComponent()" + "/"+a);
      }

      @Override
      protected void onStart() {
            super.onStart();
            Log.d(TAG, "onStart");
      }

      @Override
      protected void onResume() {
            super.onResume();
            Log.d(TAG, "onResume");
      }

      @Override
      protected void onPause() {
            super.onPause();
            Log.d(TAG, " onPause");
      }

      @Override
      protected void onStop() {
            super.onStop();
            Log.d(TAG, " onStop");
      }

      @Override
      protected void onRestart() {
            super.onRestart();
            Log.d(TAG, "onRestart");
      }

      @Override
      protected void onDestroy() {
            super.onDestroy();
            Log.d(TAG, "onDestroy");
      }

      //---------------------------------------------------------
      @Override
      public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.m0700, menu);
            return true;
      }

      @Override
      public void onBackPressed() {
            Toast.makeText(getApplicationContext(), "禁用返回建!!", Toast.LENGTH_LONG).show();
//            super.onBackPressed();
      }

      @Override
      public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement

            switch (id) {
                  case R.id.action_settings:
                        this.finish();
                        break;
            }

            return super.onOptionsItemSelected(item);
      }
      //---------------------------------------------------------
}