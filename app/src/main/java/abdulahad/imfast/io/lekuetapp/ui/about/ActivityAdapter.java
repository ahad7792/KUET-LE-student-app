package abdulahad.imfast.io.lekuetapp.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import abdulahad.imfast.io.lekuetapp.R;

public class ActivityAdapter extends PagerAdapter {
    private Context context;
    private List<ActivityModel> list;

    public ActivityAdapter(Context context, List<ActivityModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_layout, container, false);

        ImageView activity_icon;
        TextView activity_title, activity_description;

        activity_icon = (ImageView) view.findViewById(R.id.activity_icon);
        activity_title = (TextView) view.findViewById(R.id.activity_title);
        activity_description = (TextView) view.findViewById(R.id.activity_description);

        activity_icon.setImageResource(list.get(position).getImg());

        activity_title.setText(list.get(position).getTitle());
        activity_description.setText(list.get(position).getDescription());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
