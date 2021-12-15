package tw.tcnr09.m0708;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0708 extends ListActivity {

      private TextView ans;
      private String[] data01, data02;
      private ArrayList<Map<String, Object>> mList;
      View currentView;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0708);
            setupViewComponent();
      }

      private void setupViewComponent() {
            ans = findViewById(R.id.m0708_t001);
            data01 = getResources().getStringArray(R.array.teacname);
            data02 = getResources().getStringArray(R.array.descr);

            mList = new ArrayList<Map<String, Object>>();

            for (int i = 0; i < data01.length; i++) {
                  Map<String, Object> temp = new HashMap<String, Object>();

                  String idName = String.format("t%03d", (i + 1));
                  int resID = getResources().getIdentifier(idName, "drawable", getPackageName());
                  temp.put("img", resID);
                  temp.put("name", data01[i]);
//                  temp.put("desc", data02[i]);

                  mList.add(temp);

                  SimpleAdapter adapter = new SimpleAdapter(
                            getApplicationContext(),
                            mList,
                            R.layout.list_item,
                            new String[]{"img", "name"},
                            new int[]{R.id.m0708_img001, R.id.m0708_t003}
                  );

                  setListAdapter(adapter);
                  ListView listView = getListView();
                  listView.setTextFilterEnabled(true);
                  //設定ListView內Item的間距，以Piexl5為例
                  //Layout設2dp約和5等寬
                  listView.setDividerHeight(5);
                  //去掉自動產生的分隔線，分隔線是drawable檔案
                  // listView.setDivider(null);
                  listView.setOnItemClickListener(onItemClick);

            }
      }

      AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  if(currentView!=null)
                  currentView.setBackgroundColor(getResources().getColor(R.color.Lime));

                  ans.setText(getString(R.string.m0708_t001) + data01[position] + "\n" + getString(R.string.m0708_descr) + data02[position]);
                  view.setBackgroundColor(getResources().getColor(R.color.Red));
                  currentView=view;
            }

      };



}