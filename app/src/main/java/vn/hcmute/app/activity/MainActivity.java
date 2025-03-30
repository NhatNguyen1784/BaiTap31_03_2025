package vn.hcmute.app.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import vn.hcmute.app.adapter.OrderViewPager2Adapter;
import vn.hcmute.app.R;
import vn.hcmute.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private OrderViewPager2Adapter orderViewPager2Adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // tool bar
        setSupportActionBar(binding.toolbar);

        FloatingActionButton fab = binding.fabAction;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", BaseTransientBottomBar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        binding.tabLayoutOrder.addTab(binding.tabLayoutOrder.newTab().setText("Xac nhan"));
        binding.tabLayoutOrder.addTab(binding.tabLayoutOrder.newTab().setText("lay hang"));
        binding.tabLayoutOrder.addTab(binding.tabLayoutOrder.newTab().setText("Dang giao"));
        binding.tabLayoutOrder.addTab(binding.tabLayoutOrder.newTab().setText("Danh gia"));
        binding.tabLayoutOrder.addTab(binding.tabLayoutOrder.newTab().setText("Huy"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        orderViewPager2Adapter = new OrderViewPager2Adapter(fragmentManager, getLifecycle());
        binding.viewPagerOrder.setAdapter(orderViewPager2Adapter);

        binding.tabLayoutOrder.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPagerOrder.setCurrentItem(tab.getPosition());
                changeFabIcon(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPagerOrder.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tabLayoutOrder.selectTab(binding.tabLayoutOrder.getTabAt(position));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuSearch) {
            Toast.makeText(this, " ban dang chon search", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuNewGroup) {
            Toast.makeText(this, " ban dang chon more", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuBroadcast) {
            Toast.makeText(this, " ban dang chon Broadcast", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuWeb) {
            Toast.makeText(this, " ban dang chon web", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuMessage) {
            Toast.makeText(this, " ban dang chon Message", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, " ban dang chon Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeFabIcon(int position) {
        binding.fabAction.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (position) {
                    case 0:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_launcher_background));
                        break;
                    case 1:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_launcher_foreground));
                        break;
                    case 2:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_launcher_foreground));
                        break;
                }
                binding.fabAction.show();
            }
        }, 2000);
    }


}