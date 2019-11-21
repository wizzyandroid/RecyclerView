package com.wizzyst.recyclerview.view.list;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wizzyst.recyclerview.R;
import com.wizzyst.recyclerview.data.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*=============================*/
/*            AUTHOR           */
/*          JULIAN NR          */
/* juliannoorrizani@gmail.com  */
/*         21 Nov 2019         */
/*=============================*/

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;

    private List<User> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = findViewById(R.id.rv_list);

        initDummyData();
        initView();
    }

    private void initDummyData() {
        User erpan = new User("Erpan Maolana", "52", "Bandung");
        User parit = new User("Parit Mahmuding", "88", "Kalimantan Selatan");
        User boy = new User("Boy Tukiman", "74", "Boyolali");
        User mus = new User("Mus mus", "18", "Pati");
        data = Arrays.asList(erpan, parit, boy, mus);
    }

    private void initView() {
        setTitle("User");

        ListAdapter adapter = new ListAdapter();

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setHasFixedSize(true);
        rvList.setAdapter(adapter);

        adapter.insertData(data);
    }
}
