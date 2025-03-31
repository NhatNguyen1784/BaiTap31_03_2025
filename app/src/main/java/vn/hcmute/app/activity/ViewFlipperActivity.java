package vn.hcmute.app.activity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.app.R;

public class ViewFlipperActivity extends AppCompatActivity {
    private ViewFlipper viewFlipperMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_flipper);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // anh xa
        viewFlipperMain = findViewById(R.id.viewFlipperMain);

        ActionViewFlipperMain();
    }

    private void ActionViewFlipperMain() {
        List<String> listFlipper = new ArrayList<>();
        listFlipper.add("http://app/iotstar.vn/appfoods/flipper/quangcao.png");
        listFlipper.add("http://app/iotstar.vn/appfoods/flipper/coffee.jpg");
        listFlipper.add("http://app/iotstar.vn/appfoods/flipper/companypizza.png");
        listFlipper.add("http://app/iotstar.vn/appfoods/flipper/themoingon.png");

        for(int i = 0; i < listFlipper.size(); i++){
            ImageView imgProduct = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(listFlipper.get(i)).into(imgProduct);
            imgProduct.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperMain.addView(imgProduct);
        }

        viewFlipperMain.setFlipInterval(3000);
        viewFlipperMain.setAutoStart(true);

        // set animation
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipperMain.setInAnimation(slide_in);
        viewFlipperMain.setOutAnimation(slide_out);
    }
}