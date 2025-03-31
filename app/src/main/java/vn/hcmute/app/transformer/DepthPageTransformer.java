package vn.hcmute.app.transformer;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class DepthPageTransformer implements ViewPager2.PageTransformer{

    public static final float MIN_SCALE = 0.75f;
    @Override
    public void transformPage(@NonNull View page, float position) {
        int pageWidth = page.getWidth();
        if(position < -1){
            page.setAlpha(0f);
        } else if (position <= 0) {
            page.setAlpha(1f);
            page.setTranslationX(0f);
            page.setTranslationZ(0f);
            page.setScaleX(1f);
            page.setScaleY(1f);
        } else if (position <= 1) {
            page.setAlpha(1 - position);

            page.setTranslationX(pageWidth * -position);

            page.setTranslationZ(-1f);
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }
        else {
            page.setAlpha(0f);
        }
    }
}
