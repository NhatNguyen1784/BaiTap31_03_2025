package vn.hcmute.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.app.R;
import vn.hcmute.app.adapter.IconAdapter;
import vn.hcmute.app.decoration.LinePagerIndicatorDecoration;
import vn.hcmute.app.model.Icon;

public class ShopeeActivity extends AppCompatActivity {


    private List<Icon> icons = new ArrayList<>();

    private IconAdapter iconAdapter;

    private RecyclerView rcvIcon;
    private SearchView searchIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopee);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // anh xa
        rcvIcon = findViewById(R.id.rcvIcon);
        searchIcon = findViewById(R.id.searchIcon);
        searchIcon.clearFocus();

        // fake data
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));
        icons.add(new Icon(R.drawable.icon1, "thanh toan sau"));
        icons.add(new Icon(R.drawable.icon2, "Free ship"));
        icons.add(new Icon(R.drawable.icon3, "Free ship extra"));


        // set adapter
        iconAdapter = new IconAdapter(getApplicationContext(), icons);

        // set layout
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(ShopeeActivity.this, 4, RecyclerView.HORIZONTAL, false);

        rcvIcon.setLayoutManager(gridLayoutManager);
        rcvIcon.setAdapter(iconAdapter);
        rcvIcon.addItemDecoration(new LinePagerIndicatorDecoration(ShopeeActivity.this));

        // search
        searchIcon.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterListener(s);
                return true;
            }
        });
    }

    private void filterListener(String keyword){
        List<Icon> listIconFind = new ArrayList<>();
        if(keyword != null || !keyword.trim().isEmpty()){ // neu search thi moi hien thi list do ra
            for (Icon icon: icons) {
                if(icon.getImgName().toLowerCase().contains(keyword.toLowerCase())){
                    listIconFind.add(icon);
                }
            }
        }
        if (listIconFind != null){
            iconAdapter.setListenerList(listIconFind);
        }
        else {
            Toast.makeText(getApplicationContext(), "Khong co du lieu", Toast.LENGTH_SHORT).show();
        }
    }
}