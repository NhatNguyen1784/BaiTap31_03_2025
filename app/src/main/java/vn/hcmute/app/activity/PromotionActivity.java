package vn.hcmute.app.activity;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import vn.hcmute.app.R;
import vn.hcmute.app.adapter.ImageViewAdapter;
import vn.hcmute.app.model.Images;

public class PromotionActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ImageViewAdapter imageViewAdapter;
    private CircleIndicator circleIndicator;
    private List<Images> images;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onPostResume() {
        super.onPostResume();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_promotion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // anh xa
        viewPager = findViewById(R.id.viewPagePromotion);
        circleIndicator = findViewById(R.id.circle_indicator);
        images = getImageList();
        imageViewAdapter = new ImageViewAdapter(images);

        viewPager.setAdapter(imageViewAdapter);

        // lien ket viewpager voi indicator
        circleIndicator.setViewPager(viewPager);


        // auto run
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if(viewPager.getCurrentItem() == images.size() - 1){
                    viewPager.setCurrentItem(0);
                }
                else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        };

        // goi runable
        handler.postDelayed(runnable, 3000);

        // lang nghe viewpager chuyen trang
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private List<Images> getImageList() {
        List<Images> images = new ArrayList<>();

        images.add(new Images(R.drawable.coffee));
        images.add(new Images(R.drawable.hambuger));
        images.add(new Images(R.drawable.pizza));

        return images;
    }
}