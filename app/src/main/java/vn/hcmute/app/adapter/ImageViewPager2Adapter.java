package vn.hcmute.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.hcmute.app.R;
import vn.hcmute.app.model.Images;

public class ImageViewPager2Adapter extends RecyclerView.Adapter<ImageViewPager2Adapter.ImagesViewHolder> {
    private List<Images> images;

    public ImageViewPager2Adapter(List<Images> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewPager2Adapter.ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewPager2Adapter.ImagesViewHolder holder, int position) {
        // gan data
        Images image = images.get(position);
        if (image == null)
            return;
        holder.imgPro.setImageResource(image.getImgId());
    }

    @Override
    public int getItemCount() {
        return images == null ? 0: images.size();
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPro;
        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPro = itemView.findViewById(R.id.imgPro);
        }
    }
}
