package tw.tcnr09.m0704;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0704 extends ListActivity {

      private TextView mTxtResult;
      private String[] listFromResource;
      private String[] doWhat;
      //儲存篩選後的資料，用來給ListView用
      private ArrayList<Map<String, Object>> mList;


      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0704);

            setupViewComponent();
      }

      private void setupViewComponent() {
            mTxtResult = (TextView) findViewById(R.id.m0704_t001);
            //抓資料，目前寫死在Value內，未來抓資料庫
            listFromResource = getResources().getStringArray(R.array.weekday);
            doWhat = getResources().getStringArray(R.array.weekdaydo);
//---------------------------------------------------------------
            mList = new ArrayList<Map<String, Object>>();

            for (int x = 0; x < listFromResource.length; x++) {
                  Map<String, Object> item = new HashMap<String, Object>();
                  //靠getIdentifier()抓圖，不需要副檔名
                  String idName = "img"+String.format("%02d"+"th", (x + 1));
                  int resID = getResources().getIdentifier(idName, "drawable", getPackageName());
                  item.put("img", resID);
                  //一星期有七天
                  item.put("txt", listFromResource[x]);
                  item.put("do", doWhat[x]);
                  //篩選後放到mList內
                  mList.add(item);
                  //-------------------------------------------------

                  SimpleAdapter adapter = new SimpleAdapter(
                            getApplicationContext(),
                            mList,
                            R.layout.list_item,
                            new String[]{"img", "txt", "do"},
                            new int[]{R.id.m0704_img001, R.id.m0704_t003, R.id.m0704_t004}
                  );

//                  SimpleAdapter(Context,資料來源,版型ID, Key,在板型中對應的位置)
                  //----------------------------------------------------------------
                  setListAdapter(adapter);
                  ListView listview = getListView();
                  listview.setTextFilterEnabled(true);
                  listview.setOnItemClickListener(listviewOnItemClkLis);
            }
      }

      AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                  int a=0;
                  mTxtResult.setText(getString(R.string.m0704_ans) + listFromResource[position]);
            }
      };
}