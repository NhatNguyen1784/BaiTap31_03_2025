package vn.hcmute.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.hcmute.app.R;
import vn.hcmute.app.model.Icon;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconHolder>{

    private Context context;
    private List<Icon> icons;

    public IconAdapter(Context context, List<Icon> icons) {
        this.context = context;
        this.icons = icons;
    }

    @NonNull
    @Override
    public IconAdapter.IconHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon_promotion, parent, false);
        return new IconHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconAdapter.IconHolder holder, int position) {
        // gan data
        Icon icon  = icons.get(position);
        holder.tvIcon.setText(icon.getImgName());

        // load anh voi glide
        Glide.with(context).load(icon.getImgId()).into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return icons != null ? icons.size(): 0;
    }

    public void setListenerList(List<Icon> icons){
        this.icons = icons;
        notifyDataSetChanged();
    }

    public class IconHolder extends RecyclerView.ViewHolder{
        private ImageView imgIcon;
        private TextView tvIcon;

        public IconHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvIcon = itemView.findViewById(R.id.tvIcon);
        }
    }
}
