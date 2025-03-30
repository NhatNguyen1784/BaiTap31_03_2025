package vn.hcmute.app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.hcmute.app.ui.CancelFragment;
import vn.hcmute.app.ui.DeliveryFragment;
import vn.hcmute.app.ui.NewOrderFragment;
import vn.hcmute.app.ui.PickupFragment;

public class OrderViewPager2Adapter extends FragmentStateAdapter {
    public OrderViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new NewOrderFragment();
            case 1:
                return new PickupFragment();
            case 2:
                return new DeliveryFragment();
            case 4:
                return new CancelFragment();
            default:
                return new NewOrderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5; // so tab tuong ung o tren
    }
}
