package com.wizzyst.recyclerview.view.list;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wizzyst.recyclerview.R;
import com.wizzyst.recyclerview.data.User;
import com.wizzyst.recyclerview.utils.InfiniteScrollListener;

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
    private SwipeRefreshLayout refreshLayout;

    private List<User> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.srl_refresh);

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

        final ListAdapter adapter = new ListAdapter();

        adapter.addOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User item) {
                Toast.makeText(MainActivity.this, item.getName() + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setHasFixedSize(true);
        rvList.setAdapter(adapter);

        rvList.addOnScrollListener(new InfiniteScrollListener(){
            @Override
            public boolean canLoadMore() {
                //tulis code untuk menentukan kapan harus load more
                //misal if (data.size() < totalData) return true;
                //else return false;
                return true;
            }

            @Override
            public void onLoadMore() {
                //lakukan action untuk mengambil data baru, contoh:
                adapter.addData(data);
            }
        });

        adapter.insertData(data);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //tulis logic setelah melakukan swipe
                initDummyData();
                initView();
                refreshLayout.setRefreshing(false);
            }
        });
    }
}
