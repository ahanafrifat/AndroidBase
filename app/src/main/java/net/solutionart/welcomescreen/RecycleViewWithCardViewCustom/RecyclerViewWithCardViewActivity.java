package net.solutionart.welcomescreen.RecycleViewWithCardViewCustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.solutionart.welcomescreen.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewWithCardViewActivity extends AppCompatActivity {

    RecyclerView recycleView_Item;
    ItemAdapter adapter;
    List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_with_card_view);
    }

    @Override
    protected void onStart() {
        super.onStart();

        itemList = new ArrayList<>();

        itemList.add(new Item(0,"AAA"));
        itemList.add(new Item(1,"Ahanaf"));
        itemList.add(new Item(2,"Rony"));
        itemList.add(new Item(3,"Tuser"));
        itemList.add(new Item(4,"AAA"));
        itemList.add(new Item(5,"AAA"));
        itemList.add(new Item(6,"AAA"));
        itemList.add(new Item(7,"AAA"));
        itemList.add(new Item(8,"AAA"));
        itemList.add(new Item(9,"AAA"));
        itemList.add(new Item(10,"AAA"));
        itemList.add(new Item(11,"AAA"));
        itemList.add(new Item(12,"AAA"));
        itemList.add(new Item(13,"AAA"));
        itemList.add(new Item(14,"AAA"));
        itemList.add(new Item(15,"AAA"));
        itemList.add(new Item(16,"AAA"));
        itemList.add(new Item(17,"AAA"));

        recycleView_Item = (RecyclerView) findViewById(R.id.recycleViewItem);
        recycleView_Item.setHasFixedSize(true);
        recycleView_Item.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemAdapter(this, itemList);
        recycleView_Item.setAdapter(adapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
