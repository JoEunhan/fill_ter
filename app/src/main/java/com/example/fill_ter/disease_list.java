package com.example.fill_ter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class disease_list extends AppCompatActivity {
    CustomChocieListAdapter adapter;
    ArrayList<disease_list_Activity> item = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_list);

        adapter= new CustomChocieListAdapter();

        listView=(ListView) findViewById(R.id.disease_List);
        listView.setAdapter(adapter);
        generateFirstArrayList();
        item=generateMyArrayList();
/////****엑셀로 질병 부분 가져오는 거 구현하기**////


        //item = adapter.allItem();
        final EditText editText = (EditText)findViewById(R.id.editTextFilter);
        editText.setPrivateImeOptions("defaultInputmode=korean;");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = editText.getText().toString();
                search(str);
            }
        });



    }

    public void search(String str){
        item.clear();
        if(str.length()==0) item.addAll(generateMyArrayList());
        else {

        for(int j=0;j<generateMyArrayList().size();j++){
            if(generateMyArrayList().get(j).getText().contains(str)){
               item.add(generateMyArrayList().get(j));
            }

        }
        adapter.notifyDataSetChanged();
    }
    }

    private ArrayList<disease_list_Activity> generateMyArrayList(){
        String itemName[] = getResources().getStringArray(R.array.disease_type);
        // String itemDescription[] = getResources().getStringArray(R.array.item_description);

        ArrayList<disease_list_Activity> nlist = new ArrayList<>();

        for(int i=0;i<itemName.length;i++){
            //adapter.addItem(itemName[i]);
            disease_list_Activity item = new disease_list_Activity();
            item.setText(itemName[i]);

            nlist.add(item);
        }
        //nlist.addAll(adapter.allItem());

        return nlist;

    }

    private void generateFirstArrayList(){
        String itemName[] = getResources().getStringArray(R.array.disease_type);
        // String itemDescription[] = getResources().getStringArray(R.array.item_description);

        //ArrayList<disease_list_Activity> nlist = new ArrayList<>();

        for(int i=0;i<itemName.length;i++){
            adapter.addItem(itemName[i]);

        }
        //nlist.addAll(adapter.allItem());



    }
}