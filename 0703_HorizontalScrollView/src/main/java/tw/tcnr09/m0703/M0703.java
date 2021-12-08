package tw.tcnr09.m0703;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class M0703 extends AppCompatActivity implements
          ViewSwitcher.ViewFactory,
          AdapterView.OnItemClickListener {

      // 圖庫的圖片資源索引
      private Integer[] imgArr = {
                R.drawable.img01, R.drawable.img02,
                R.drawable.img03, R.drawable.img04,
                R.drawable.img05, R.drawable.img06,
                R.drawable.img07, R.drawable.img08,
                R.drawable.img09, R.drawable.img10,
                R.drawable.img11, R.drawable.img12,
                R.drawable.img13, R.drawable.img14,
                R.drawable.img15, R.drawable.img16,
      };

      private Integer[] thumbImgArr = {
                R.drawable.img01th, R.drawable.img02th,
                R.drawable.img03th, R.drawable.img04th,
                R.drawable.img05th, R.drawable.img06th,
                R.drawable.img07th, R.drawable.img08th,
                R.drawable.img09th, R.drawable.img10th,
                R.drawable.img11th, R.drawable.img12th,
                R.drawable.img13th, R.drawable.img14th,
                R.drawable.img15th, R.drawable.img16th,
      };

      private ImageSwitcher imgSwi;
      private GridView gridview;
      private int ss = 1;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0703);
            setupViewComponent();
      }

      private void setupViewComponent() {
            //自定義方法
            // 取得GridView元件
            gridview = (GridView) findViewById(R.id.m0703_gv001);
            //將縮圖填入 GridView
            setGridView();
            //-----------------------------
            // 從資源類別R中取得介面元件
            imgSwi = (ImageSwitcher) findViewById(R.id.m0703_img001);
            imgSwi.setFactory((ViewSwitcher.ViewFactory) this); // 必須implements ViewSwitcher.ViewFactory
            // GridView元件的事件處理
            gridview.setOnItemClickListener((AdapterView.OnItemClickListener) this);

      }

      private void setGridView() {
            //Layout的排序決定顯示的前後次序
            //先取得圖片數量，因圖片用Array裝起來，所以可以用length取得數量
            int size = thumbImgArr.length; //找出圖片張數
            int length = 120; //縮圖的寬度
            //----------------------
            DisplayMetrics dm = new DisplayMetrics(); //找出使用者手機的寬高
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            float density = dm.density;
            float w = dm.widthPixels;
            float h = dm.heightPixels;
            int gridviewWidth = (int) (size * (length + 10) * density * 0.9); //整個水平選單的寬度
            int itemWidth = (int) (length * density * 0.9); //每個縮圖佔的寬度

//            String aa = "等一下";

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                      gridviewWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
            gridview.setLayoutParams(params);
            gridview.setColumnWidth(itemWidth);//設定Grid的寬度
            gridview.setHorizontalSpacing(20); // 間距
            gridview.setStretchMode(GridView.NO_STRETCH); //
            gridview.setNumColumns(size); //一行有幾個
            gridview.setAdapter(new GridAdapter(this, thumbImgArr));
      }

      @Override
      public View makeView() {
//            ImageView v = new ImageView(this);
//            v.setBackgroundColor(0xFF000000);
//            v.setLayoutParams(new ImageSwitcher.LayoutParams(
//                      LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            return v;
            ImageView v = new ImageView(this);
            v.setBackgroundColor(0x00000000);
            v.setLayoutParams(new ImageSwitcher.LayoutParams(
                      LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            return v;
      }

      @Override
      public void onPointerCaptureChanged(boolean hasCapture) {

      }

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Animation anim;
            //清空動畫設定
            imgSwi.destroyDrawingCache();
            imgSwi.setAnimation(null);
            imgSwi.setOutAnimation(null);
            imgSwi.setInAnimation(null);
            imgSwi.clearAnimation();

            switch (ss) {
                  case 1:
                        //透明
                        imgSwi.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_alpha_out));
                        imgSwi.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_alpha_in));
                        Toast.makeText(getApplicationContext(), getString(R.string.m0703_alpha), Toast.LENGTH_SHORT).show();
                        break;
                  case 2:
                        //縮放
                        imgSwi.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_scale_rotate_out));
                        imgSwi.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_scale_rotate_in));
                        Toast.makeText(getApplicationContext(), getString(R.string.m0703_rotate), Toast.LENGTH_SHORT).show();
                        break;
                  case 3:
                        //位移
                        imgSwi.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_trans_out));
                        imgSwi.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_trans_in));
                        Toast.makeText(getApplicationContext(), getString(R.string.m0703_trans), Toast.LENGTH_SHORT).show();
                        break;
                  case 4:
                        //彈跳
                        anim = AnimationUtils.loadAnimation(this, R.anim.anim_trans_bounce);
                        //設定彈跳特效
                        anim.setInterpolator(new BounceInterpolator());
                        imgSwi.setAnimation(anim);
                        Toast.makeText(getApplicationContext(), getString(R.string.m0703_bounce), Toast.LENGTH_SHORT).show();
                        break;
                  case 5:
                        anim = AnimationUtils.loadAnimation(this, R.anim.anim_custom_out);
                        //設定彈跳特效
                        anim.setInterpolator(new BounceInterpolator());
                        imgSwi.setAnimation(anim);
                        Toast.makeText(getApplicationContext(), getString(R.string.Item05), Toast.LENGTH_SHORT).show();
                        break;
            }

            imgSwi.setImageResource(imgArr[position]);
      }

      @Override
      protected void onStart() {
            super.onStart();
      }

      @Override
      protected void onResume() {
            super.onResume();
      }

      @Override
      protected void onPause() {
            super.onPause();
      }

      @Override
      protected void onStop() {
            super.onStop();
      }

      @Override
      protected void onDestroy() {
            super.onDestroy();
      }

      //---------------------------------------------------------
      @Override
      public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.m0703, menu);
            return true;
      }

      @Override
      public void onBackPressed() {
            Toast.makeText(getApplicationContext(), "禁用返回建!!", Toast.LENGTH_LONG).show();
//            super.onBackPressed();
      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement

            switch (id) {
                  case R.id.Item01:
                        ss = 1;
                        break;
                  case R.id.Item02:
                        ss = 2;
                        break;
                  case R.id.Item03:
                        ss = 3;
                        break;
                  case R.id.Item04:
                        ss = 4;
                        break;
                  case R.id.Item05:
                        ss = 5;
                        break;
                  case R.id.action_settings:
                        this.finish();
                        break;
            }

            return super.onOptionsItemSelected(item);
      }

      //---------------------------------------------------------
}