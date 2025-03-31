package vn.hcmute.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import vn.hcmute.app.R;
import vn.hcmute.app.model.Images;

public class ImageViewAdapter extends PagerAdapter {
    private List<Images> images;

    public ImageViewAdapter(List<Images> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_images, container, false);

        ImageView imgPro = view.findViewById(R.id.imgPro);
        Images img = images.get(position);
        imgPro.setImageResource(img.getImgId());

        // add view
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
