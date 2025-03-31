package vn.hcmute.app.activity;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import vn.hcmute.app.R;
import vn.hcmute.app.adapter.ImageViewPager2Adapter;
import vn.hcmute.app.model.Images;
import vn.hcmute.app.transformer.DepthPageTransformer;

public class HomeActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private List<Images> images;
    private CircleIndicator3 circleIndicator3;
    private ImageViewPager2Adapter imageViewPager2Adapter;

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // anh xa
        viewPager2 = findViewById(R.id.viewPage2);
        circleIndicator3 = findViewById(R.id.circle_indicator_3);

        images = getImageList();
        imageViewPager2Adapter = new ImageViewPager2Adapter(images);

        viewPager2.setAdapter(imageViewPager2Adapter);

        // lien ket viewpager2 voi circleIndiCator3
        circleIndicator3.setViewPager(viewPager2);

        handler = new Handler();
        // auto run
        runnable = new Runnable() {
            @Override
            public void run() {
                if(viewPager2.getCurrentItem() == images.size() - 1){
                    viewPager2.setCurrentItem(0);
                }
                else {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                }
            }
        };

        // lang nghe viewpager2 chuyen trang
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        });

        viewPager2.setPageTransformer(new DepthPageTransformer());
    }


    private List<Images> getImageList() {
        List<Images> images = new ArrayList<>();

        images.add(new Images(R.drawable.coffee));
        images.add(new Images(R.drawable.hambuger));
        images.add(new Images(R.drawable.pizza));

        return images;
    }
}